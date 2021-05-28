package com.github.majdibo.workman.adapter.persistence.process

import com.github.majdibo.workman.adapter.persistence.process.entity.BusinessProcessEntity
import com.github.majdibo.workman.core.base.dao.AbstractBaseDomainRepository
import com.github.majdibo.workman.core.base.dao.BaseDaoRepository
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.domain.process.BusinessProcess
import com.github.majdibo.workman.domain.process.BusinessProcesses
import org.springframework.stereotype.Repository

@Repository
class BusinessProcessRepository : AbstractBaseDomainRepository<BusinessProcess, NumericIdentifier, BusinessProcessEntity, LongIdentifier>(), BusinessProcesses

interface BusinessProcessDaoRepository : BaseDaoRepository<BusinessProcessEntity, LongIdentifier>
