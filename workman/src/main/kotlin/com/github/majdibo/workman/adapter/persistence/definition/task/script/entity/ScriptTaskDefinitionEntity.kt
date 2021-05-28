package com.github.majdibo.workman.adapter.persistence.definition.task.script.entity

import com.github.majdibo.workman.adapter.persistence.definition.task.TaskDefinitionEntity
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "SCRIPT_TASK_DEFINITION")
class ScriptTaskDefinitionEntity : TaskDefinitionEntity<ScriptTaskDefinition>() {

    @Column
    lateinit var name: String

    @Column
    var script: String = ""

    override fun toDomain(): ScriptTaskDefinition = ScriptTaskDefinition(name, script).also { it.id = identifier.value }

}
