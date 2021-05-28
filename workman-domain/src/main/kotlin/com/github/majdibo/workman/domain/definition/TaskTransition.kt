package com.github.majdibo.workman.domain.definition

import com.github.majdibo.workman.domain.definition.task.TaskDefinition

data class TaskTransition(val id: Long=-1, val from: TaskDefinition, val to: TaskDefinition, val waitCompletion: Boolean = false)