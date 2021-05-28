package com.github.majdibo.workman.adapter.persistence.definition.entity

import com.github.majdibo.workman.adapter.persistence.definition.task.TaskDefinitionEntity
import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.domain.definition.TaskTransition
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity(name = "TASK_TRANSITION")
class TaskTransitionEntity : BaseEntity<TaskTransition, LongIdentifier>() {

    @ManyToOne
    lateinit var from: TaskDefinitionEntity<out TaskDefinition>

    @ManyToOne
    lateinit var to: TaskDefinitionEntity<out TaskDefinition>

    @Column
    var waitCompletion: Boolean = false

    override fun toDomain(): TaskTransition {
        return TaskTransition(identifier.value, from.toDomain(), to.toDomain(), waitCompletion)
    }

}
