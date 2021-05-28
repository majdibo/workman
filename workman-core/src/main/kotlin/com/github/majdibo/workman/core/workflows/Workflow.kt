package com.github.majdibo.workman.core.workflows

import com.github.majdibo.workman.core.workflows.TaskStatus.ERROR_CODE
import com.github.majdibo.workman.core.workflows.TaskStatus.SUCCESS_CODE

open class Workflow<T: Task>(var taskPath: TaskPath<T>) : Task {

    override fun execute() = taskPath.tasks.onEach {
        val taskStatus = it.execute()
        if (taskStatus != SUCCESS_CODE) return ERROR_CODE
    }.run { SUCCESS_CODE }

    override fun addParallelTasks(task: Task): Task {
        TODO("Not yet implemented")
    }

}