package com.github.majdibo.workman.adapter.persistence.definition

import com.github.majdibo.workman.adapter.persistence.definition.entity.BusinessProcessDefinitionEntity
import com.github.majdibo.workman.core.base.dao.AbstractBaseDomainRepository
import com.github.majdibo.workman.core.base.dao.BaseDaoRepository
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.core.base.dao.entity.identifier.StringIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.domain.definition.BusinessProcessDefinition
import com.github.majdibo.workman.domain.definition.ProcessDefinitions
import org.springframework.stereotype.Repository

@Repository
class ProcessDefinitionRepository : AbstractBaseDomainRepository<BusinessProcessDefinition, TextIdentifier, BusinessProcessDefinitionEntity, StringIdentifier>(), ProcessDefinitions


interface ProcessDefinitionDaoRepository : BaseDaoRepository<BusinessProcessDefinitionEntity, StringIdentifier>
