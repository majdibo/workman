package com.github.majdibo.workman.adapter.persistence.definition.task

import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity(name = "TASK_DEFINITION")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class TaskDefinitionEntity<T: TaskDefinition>  : BaseEntity<T, LongIdentifier>()
