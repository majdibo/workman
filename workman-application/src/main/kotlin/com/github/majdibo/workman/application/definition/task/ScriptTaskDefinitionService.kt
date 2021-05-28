package com.github.majdibo.workman.application.definition.task

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.core.base.service.BaseService
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinitions

class ScriptTaskDefinitionService(private val scriptTaskDefinitions: ScriptTaskDefinitions) : BaseService<ScriptTaskDefinition, NumericIdentifier> {
    override fun findAll(): List<ScriptTaskDefinition> {
        return scriptTaskDefinitions.findAll()
    }

    override fun save(entity: ScriptTaskDefinition): ScriptTaskDefinition {
        return scriptTaskDefinitions.save(entity)
    }

    override fun delete(id: NumericIdentifier) {
        scriptTaskDefinitions.delete(id)
    }

    override fun findById(id: NumericIdentifier): ScriptTaskDefinition? {
        return scriptTaskDefinitions.findById(id)
    }

    override fun parseIdentifier(string: String) = NumericIdentifier.parse(string)
}
