package com.github.majdibo.workman.domain.process

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.core.base.service.BaseDomainRepository
import com.github.majdibo.workman.core.workflows.TaskPath
import com.github.majdibo.workman.core.workflows.Workflow
import com.github.majdibo.workman.domain.process.task.BusinessTask
import java.time.LocalDateTime

class BusinessProcess(val processDefinition: TextIdentifier,
                      val executionTime: LocalDateTime,
                      taskPath: TaskPath<BusinessTask>) : Workflow<BusinessTask>(taskPath) {
    lateinit var id: NumericIdentifier
}

interface BusinessProcesses : BaseDomainRepository<BusinessProcess, NumericIdentifier>