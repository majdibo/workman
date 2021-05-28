package com.github.majdibo.workman.core.workflows.tasks

import com.github.majdibo.workman.core.workflows.WorkflowException

class ErrorTask(name: String) : NamedTask(name) {
    override fun process() {
        super.process()
        throw WorkflowException("Exception is thrown")
    }
}