package com.github.majdibo.workman.domain.process.task

object StartingTask : BusinessTask() {
    override fun process() {
        log.info("Starting Tasks loading ...")
    }
}