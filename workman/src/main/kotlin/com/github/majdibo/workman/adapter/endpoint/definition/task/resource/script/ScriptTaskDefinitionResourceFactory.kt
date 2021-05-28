package com.github.majdibo.workman.adapter.endpoint.definition.task.resource.script

import com.github.majdibo.workman.core.base.controller.resource.BaseResourceFactory
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import org.springframework.stereotype.Service

@Service
class ScriptTaskDefinitionResourceFactory : BaseResourceFactory<ScriptTaskDefinition, ScriptTaskDefinitionResource> {
    override fun of(domain: ScriptTaskDefinition): ScriptTaskDefinitionResource {
        return ScriptTaskDefinitionResource(domain.id, domain.name, domain.script)
    }

}
