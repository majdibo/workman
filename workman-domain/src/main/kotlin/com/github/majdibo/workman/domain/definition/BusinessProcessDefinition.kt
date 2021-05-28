package com.github.majdibo.workman.domain.definition

import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskType


data class BusinessProcessDefinition(val name: TextIdentifier) : TaskDefinition(TaskType.PROCESS) {
    val transitions: MutableList<TaskTransition> = ArrayList()


    fun addTransition(transition: TaskTransition) {
        transitions.add(transition)
    }
}


