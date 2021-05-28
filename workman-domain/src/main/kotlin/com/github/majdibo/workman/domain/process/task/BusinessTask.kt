package com.github.majdibo.workman.domain.process.task

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.core.workflows.BaseTask
import java.time.LocalDateTime

abstract class BusinessTask : BaseTask() {
    lateinit var id: NumericIdentifier
    lateinit var executionDate: LocalDateTime
    var state : BusinessTaskState = BusinessTaskState.CREATED
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BusinessTask

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
