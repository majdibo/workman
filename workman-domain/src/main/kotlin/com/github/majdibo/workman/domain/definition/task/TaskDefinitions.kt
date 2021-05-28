package com.github.majdibo.workman.domain.definition.task

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.core.base.service.BaseDomainRepository

interface TaskDefinitions : BaseDomainRepository<TaskDefinition, NumericIdentifier>