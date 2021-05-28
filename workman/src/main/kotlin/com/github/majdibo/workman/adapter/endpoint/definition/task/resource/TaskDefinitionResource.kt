package com.github.majdibo.workman.adapter.endpoint.definition.task.resource

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.github.majdibo.workman.adapter.endpoint.definition.task.resource.script.ScriptTaskDefinitionResource
import com.github.majdibo.workman.adapter.endpoint.definition.task.resource.script.ScriptTaskDefinitionResourceFactory
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinitionException
import org.springframework.stereotype.Service

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes(value = [
    JsonSubTypes.Type(name = "script", value = ScriptTaskDefinitionResource::class)
])
interface TaskDefinitionResource {
    val id: Long?
    fun toDomain(): TaskDefinition
}

@Service
class TaskDefinitionResourceFactory {
    fun of(taskDefinition: TaskDefinition): TaskDefinitionResource {
        return when (taskDefinition) {
            is ScriptTaskDefinition -> ScriptTaskDefinitionResourceFactory().of(taskDefinition)
            else -> throw TaskDefinitionException("task definition type is not supported yet : $taskDefinition")
        }
    }

}