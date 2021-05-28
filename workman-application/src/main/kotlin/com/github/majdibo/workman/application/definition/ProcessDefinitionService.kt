package com.github.majdibo.workman.application.definition

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.core.base.service.BaseService
import com.github.majdibo.workman.domain.definition.BusinessProcessDefinition
import com.github.majdibo.workman.domain.definition.ProcessDefinitions
import com.github.majdibo.workman.domain.definition.TaskTransition
import com.github.majdibo.workman.domain.definition.task.TaskDefinitionException
import com.github.majdibo.workman.domain.definition.task.TaskDefinitions

class ProcessDefinitionService(private val processDefinitions: ProcessDefinitions,
                               private val taskDefinitions: TaskDefinitions) : BaseService<BusinessProcessDefinitionHolder, TextIdentifier> {

    override fun findAll(): List<BusinessProcessDefinitionHolder> {
        return processDefinitions.findAll().map { BusinessProcessDefinitionHolder.of(it) }
    }

    override fun save(entity: BusinessProcessDefinitionHolder): BusinessProcessDefinitionHolder {
        val domain = BusinessProcessDefinition(entity.name)

        entity.transitions.map {
            val from = getTaskDefinition(it.from)
            val to = getTaskDefinition(it.to)
            TaskTransition(it.id, from, to, it.waitCompletion)
        }.forEach { domain.addTransition(it) }

        return processDefinitions.save(domain).let { BusinessProcessDefinitionHolder.of(it) }
    }

    private fun getTaskDefinition(id: NumericIdentifier) =
            (taskDefinitions.findById(id)
                    ?: throw TaskDefinitionException("task definition $id is not found"))

    override fun delete(id: TextIdentifier) {
        processDefinitions.delete(id)
    }

    override fun findById(id: TextIdentifier): BusinessProcessDefinitionHolder? {
        return processDefinitions.findById(id)?.let { BusinessProcessDefinitionHolder.of(it) }
    }

    override fun parseIdentifier(string: String) = TextIdentifier.parse(string)
}