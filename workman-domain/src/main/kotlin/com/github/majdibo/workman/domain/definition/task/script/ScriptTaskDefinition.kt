package com.github.majdibo.workman.domain.definition.task.script

import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskType

data class ScriptTaskDefinition(val name: String, val script: String = "") : TaskDefinition(TaskType.SCRIPT)