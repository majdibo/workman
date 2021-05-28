package com.github.majdibo.workman.adapter.endpoint.definition.resource

import com.github.majdibo.workman.application.definition.TaskTransitionReferenceHolder
import com.github.majdibo.workman.core.base.controller.resource.BaseResource
import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier

class TaskTransitionResource(val from: Long, val to: Long, val waitCompletion: Boolean) : BaseResource<TaskTransitionReferenceHolder> {

    override fun to() = TaskTransitionReferenceHolder(from = NumericIdentifier.of(from), to = NumericIdentifier.of(to), waitCompletion = waitCompletion)
}
