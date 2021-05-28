package com.github.majdibo.workman.core.workflows.tasks

import com.github.majdibo.workman.core.workflows.BaseTask

open class NamedTask(private val name: String) : BaseTask() {
    override fun process() {
        log.info("Executing Task : $name")
    }
}