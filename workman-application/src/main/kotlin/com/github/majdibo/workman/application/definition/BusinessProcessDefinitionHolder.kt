package com.github.majdibo.workman.application.definition

import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.domain.definition.BusinessProcessDefinition

data class BusinessProcessDefinitionHolder(val name: TextIdentifier, val transitions: List<TaskTransitionReferenceHolder>) {
    companion object {
        fun of(businessProcessDefinition: BusinessProcessDefinition) = businessProcessDefinition.run { BusinessProcessDefinitionHolder(name, transitions.map { TaskTransitionReferenceHolder.of(it) }) }
    }
}