package com.github.majdibo.workman.adapter.persistence.definition.task.script.entity

import com.github.majdibo.workman.core.base.dao.entity.BaseEntityFactory
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import org.springframework.stereotype.Service

@Service
class ScriptTaskDefinitionEntityFactory : BaseEntityFactory<ScriptTaskDefinition, ScriptTaskDefinitionEntity> {
    override fun of(domain: ScriptTaskDefinition): ScriptTaskDefinitionEntity {
        return ScriptTaskDefinitionEntity().apply {
            identifier = LongIdentifier.of(domain.id)
            name = domain.name
            script = domain.script
        }
    }
}