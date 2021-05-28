package com.github.majdibo.workman.core.workflows

import java.util.*

class TaskPath<T: Task> {
    var tasks: MutableList<T> = ArrayList()

    fun addTask(task: T) = apply { tasks.add(task) }
}