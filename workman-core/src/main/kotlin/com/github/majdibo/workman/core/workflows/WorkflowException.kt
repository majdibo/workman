package com.github.majdibo.workman.core.workflows

open class WorkflowException(msg: String, ex: Throwable? = null) : RuntimeException(msg, ex)
open class TaskExecutionException(msg: String, ex: Throwable? = null) : WorkflowException(msg, ex)