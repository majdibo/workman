package com.github.majdibo.workman.domain.process

import com.github.majdibo.workman.domain.definition.task.TaskDefinition

class TaskDefinitionTreeNodeElement(val definition: TaskDefinition? = null, var next: TaskDefinitionTreeNodeElement? = null){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TaskDefinitionTreeNodeElement

        if (definition != other.definition) return false

        return true
    }

    override fun hashCode(): Int {
        return definition?.hashCode() ?: 0
    }
}