package com.github.majdibo.workman.domain.process.task

enum class BusinessTaskState {
    CREATED,
    WAITING,
    RUNNING,
    BLOCKED,
    TERMINATED
}