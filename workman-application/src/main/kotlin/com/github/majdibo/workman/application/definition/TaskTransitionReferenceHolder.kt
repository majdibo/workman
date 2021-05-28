package com.github.majdibo.workman.application.definition

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.domain.definition.TaskTransition


data class TaskTransitionReferenceHolder(val id: Long = -1, val from: NumericIdentifier, val to: NumericIdentifier, val waitCompletion: Boolean) {
    companion object {
        fun of(taskTransition: TaskTransition) = taskTransition.run { TaskTransitionReferenceHolder(id, NumericIdentifier.of(from.id), NumericIdentifier.of(to.id), waitCompletion) }
    }
}

