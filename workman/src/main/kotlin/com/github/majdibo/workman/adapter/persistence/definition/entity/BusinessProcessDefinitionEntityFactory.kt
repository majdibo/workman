package com.github.majdibo.workman.adapter.persistence.definition.entity

import com.github.majdibo.workman.adapter.persistence.definition.task.script.entity.ScriptTaskDefinitionEntity
import com.github.majdibo.workman.adapter.persistence.definition.task.script.entity.ScriptTaskDefinitionEntityFactory
import com.github.majdibo.workman.core.base.dao.entity.BaseEntityFactory
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.core.base.dao.entity.identifier.mapper.StringIdentifierMapper
import com.github.majdibo.workman.domain.definition.BusinessProcessDefinition
import com.github.majdibo.workman.domain.definition.TaskTransition
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinitionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessProcessDefinitionEntityFactory : BaseEntityFactory<BusinessProcessDefinition, BusinessProcessDefinitionEntity> {

    @Autowired
    private lateinit var taskTransitionEntityFactory: TaskTransitionEntityFactory

    @Autowired
    private lateinit var stringIdentifierMapper: StringIdentifierMapper

    override fun of(domain: BusinessProcessDefinition): BusinessProcessDefinitionEntity {
        return BusinessProcessDefinitionEntity().apply {
            identifier = stringIdentifierMapper.from(domain.name)
            taskTransitions.addAll(domain.transitions.map { taskTransitionEntityFactory.of(it) })
        }
    }
}

@Service
class TaskTransitionEntityFactory : BaseEntityFactory<TaskTransition, TaskTransitionEntity>{

    @Autowired
    private lateinit var taskDefinitionEntityFactory: TaskDefinitionEntityFactory

    override fun of(domain: TaskTransition): TaskTransitionEntity {
        return TaskTransitionEntity().apply {
            identifier = LongIdentifier()
            from = taskDefinitionEntityFactory.of(domain.from)
            to = taskDefinitionEntityFactory.of(domain.to)
            waitCompletion = domain.waitCompletion
        }
    }

}


@Service
class TaskDefinitionEntityFactory {
    fun of(taskDefinition: TaskDefinition): ScriptTaskDefinitionEntity {
        return when (taskDefinition) {
            is ScriptTaskDefinition -> ScriptTaskDefinitionEntityFactory().of(taskDefinition)
            else -> throw TaskDefinitionException("task definition type is not supported yet : $taskDefinition")
        }
    }

}