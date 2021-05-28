package com.github.majdibo.workman.domain.process.task.script

import com.github.majdibo.workman.core.workflows.WorkflowException

class ScriptTaskException(msg: String, ex: Throwable? = null) : WorkflowException(msg, ex)