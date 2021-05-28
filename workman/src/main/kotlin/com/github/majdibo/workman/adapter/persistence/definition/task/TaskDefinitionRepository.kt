package com.github.majdibo.workman.adapter.persistence.definition.task

import com.github.majdibo.workman.core.base.dao.BaseDaoRepository
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.core.base.dao.entity.identifier.mapper.LongIdentifierMapper
import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinitions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TaskDefinitionRepository(private val taskDefinitionDaoRepository: TaskDefinitionDaoRepository) : TaskDefinitions {

    @Autowired
    private lateinit var identifierMapper: LongIdentifierMapper

    override fun findAll(): List<TaskDefinition> {
        return taskDefinitionDaoRepository.findAll().map { it.toDomain() }
    }

    override fun save(domain: TaskDefinition): TaskDefinition {
        throw NotImplementedError("see specific implementation of task definition")
    }

    override fun delete(id: NumericIdentifier) {
        val identifier = identifierMapper.from(id)
        taskDefinitionDaoRepository.deleteById(identifier)
    }

    override fun findById(id: NumericIdentifier): TaskDefinition? {
        val identifier = identifierMapper.from(id)
        val optional = taskDefinitionDaoRepository.findById(identifier)
        return if (optional.isPresent) optional.get().toDomain() else null
    }
}

interface TaskDefinitionDaoRepository : BaseDaoRepository<TaskDefinitionEntity<TaskDefinition>, LongIdentifier>
