package com.github.majdibo.workman.core.base.dao.entity.identifier.mapper

import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.BusinessIdentifier


interface IdentifierMapper<ID: BaseIdentifier, BID: BusinessIdentifier> {
    fun from(id: BID): ID
    fun from(id: ID): BID

}


