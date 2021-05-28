package com.github.majdibo.workman.domain.process.task.script

import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.process.task.BusinessTask
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ScriptTask(private val taskDefinition: ScriptTaskDefinition, private val requestHandler: RequestHandler) : BusinessTask() {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun process() {
        logger.info("execute script : ${taskDefinition.name} ")
        requestHandler.execute(taskDefinition.script, emptyMap())
    }

}
