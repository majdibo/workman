package com.github.majdibo.workman.adapter.endpoint.definition.task.resource.script

import com.github.majdibo.workman.adapter.endpoint.definition.task.resource.TaskDefinitionResource
import com.github.majdibo.workman.core.base.controller.resource.BaseResource
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinition

data class ScriptTaskDefinitionResource(
        override val id: Long = -1,
        val name: String,
        val script: String = ""
) : BaseResource<ScriptTaskDefinition>, TaskDefinitionResource {
    override fun toDomain(): TaskDefinition {
        return to()
    }

    override fun to(): ScriptTaskDefinition = ScriptTaskDefinition(name, script).also { it.id = id }
}

