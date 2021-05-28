package com.github.majdibo.workman.core.workflows

interface WorkflowBuilder {
    fun build(): Workflow<out Task>
}