package com.github.majdibo.workman.domain.definition.task.script

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.core.base.service.BaseDomainRepository

interface ScriptTaskDefinitions : BaseDomainRepository<ScriptTaskDefinition, NumericIdentifier>

