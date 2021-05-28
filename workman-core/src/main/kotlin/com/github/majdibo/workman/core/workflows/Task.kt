package com.github.majdibo.workman.core.workflows


interface Task {
    fun execute(): TaskStatus
    fun addParallelTasks(task: Task): Task
}