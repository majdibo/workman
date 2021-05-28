package com.github.majdibo.workman.domain.definition

import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.core.base.service.BaseDomainRepository

interface ProcessDefinitions : BaseDomainRepository<BusinessProcessDefinition, TextIdentifier> 