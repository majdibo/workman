package com.github.majdibo.workman.domain.process.task

import com.github.majdibo.workman.core.workflows.WorkflowException
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.definition.task.StartingTaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import com.github.majdibo.workman.domain.process.task.script.RequestHandler
import com.github.majdibo.workman.domain.process.task.script.ScriptTask

class TaskFactory(private val requestHandler: RequestHandler) {

    fun from(taskDefinition: TaskDefinition): BusinessTask {
        return when (taskDefinition) {
            is StartingTaskDefinition -> StartingTask
            is ScriptTaskDefinition -> ScriptTask(taskDefinition, requestHandler)
            else -> throw WorkflowException("task definition type is unknown")
        }
    }
}