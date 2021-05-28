package com.github.majdibo.workman.domain.definition.task

abstract class TaskDefinition (
    val type: TaskType,
    var id: Long = -1
)

object StartingTaskDefinition : TaskDefinition(TaskType.STARTING)

object EndingTaskDefinition : TaskDefinition(TaskType.ENDING)