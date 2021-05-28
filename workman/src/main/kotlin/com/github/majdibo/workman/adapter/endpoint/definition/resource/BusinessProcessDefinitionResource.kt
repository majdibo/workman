package com.github.majdibo.workman.adapter.endpoint.definition.resource

import com.github.majdibo.workman.application.definition.BusinessProcessDefinitionHolder
import com.github.majdibo.workman.core.base.controller.resource.BaseResource
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier

data class BusinessProcessDefinitionResource(val name: String, val transitions: List<TaskTransitionResource> = emptyList()) : BaseResource<BusinessProcessDefinitionHolder> {

    override fun to(): BusinessProcessDefinitionHolder {
        return BusinessProcessDefinitionHolder(TextIdentifier.of(name), transitions.map { it.to() })
    }
}
