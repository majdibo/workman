package com.github.majdibo.workman.domain.process

import com.github.majdibo.workman.core.utils.TreeNode
import com.github.majdibo.workman.core.workflows.TaskPath
import com.github.majdibo.workman.core.workflows.WorkflowBuilder
import com.github.majdibo.workman.domain.definition.BusinessProcessDefinition
import com.github.majdibo.workman.domain.definition.task.StartingTaskDefinition
import com.github.majdibo.workman.domain.process.task.BusinessTask
import com.github.majdibo.workman.domain.process.task.TaskFactory
import java.time.LocalDateTime

class BusinessProcessBuilder(
    private val processDefinition: BusinessProcessDefinition,
    private val taskFactory: TaskFactory
) : WorkflowBuilder {

    private var executionTime = LocalDateTime.now()

    fun executionTime(executionTime: LocalDateTime) = apply { this.executionTime = executionTime }

    override fun build(): BusinessProcess {
        val taskDefinitionTree = transformProcessToTree(processDefinition)

        val taskPath = TaskPath<BusinessTask>()

        buildTask(taskDefinitionTree).forEach {
            taskPath.addTask(it)
        }

        return BusinessProcess(processDefinition.name, executionTime, taskPath)
    }


    private fun buildTask(tree: TreeNode<TaskDefinitionTreeNodeElement>): List<BusinessTask> {
        val result = ArrayList<BusinessTask>()

        val task = taskFactory.from(tree.value?.definition!!)
        val next = tree.value?.next

        result.add(task)

        if (tree.count() == 1) {
            result.addAll(buildTask(tree.single()))
        } else {
            tree.filter { element -> !(next != null && element.value == next) }
                .forEach { buildTask(it).forEach { subTask -> task.addParallelTasks(subTask) }}

            next?.let { result.add(taskFactory.from(it.definition!!)) }
        }


        return result
    }

    private fun transformProcessToTree(processDefinition: BusinessProcessDefinition): TreeNode<TaskDefinitionTreeNodeElement> {
        val treeNode = TreeNode(TaskDefinitionTreeNodeElement(StartingTaskDefinition))

        processDefinition.transitions.forEach {
            val from = TaskDefinitionTreeNodeElement(
                it.from,
                if (it.waitCompletion) TaskDefinitionTreeNodeElement(it.to) else null
            )
            val node = treeNode.getChild(from) ?: TreeNode(from).apply { treeNode.addChild(this) }

            node.addChild(TaskDefinitionTreeNodeElement(it.to))
        }

        return treeNode
    }


}


