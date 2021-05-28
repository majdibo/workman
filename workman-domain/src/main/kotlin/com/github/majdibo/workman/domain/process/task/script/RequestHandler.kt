package com.github.majdibo.workman.domain.process.task.script

interface RequestHandler {
    fun execute(script: String, parameters: Map<String, Any>)

}
