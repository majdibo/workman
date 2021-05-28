package com.github.majdibo.workman.adapter.persistence.process.entity

import com.github.majdibo.workman.core.base.dao.entity.BaseEntityFactory
import com.github.majdibo.workman.core.base.dao.entity.identifier.mapper.LongIdentifierMapper
import com.github.majdibo.workman.domain.process.BusinessProcess
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessProcessEntityFactory : BaseEntityFactory<BusinessProcess, BusinessProcessEntity> {

    @Autowired
    lateinit var longIdentifierMapper: LongIdentifierMapper

    override fun of(domain: BusinessProcess): BusinessProcessEntity {
        return BusinessProcessEntity().apply {
            identifier = longIdentifierMapper.from(domain.id)
            //todo taskTransitions.addAll(domain.transitions.map { taskTransitionEntityFactory.of(it) })
        }
    }
}
