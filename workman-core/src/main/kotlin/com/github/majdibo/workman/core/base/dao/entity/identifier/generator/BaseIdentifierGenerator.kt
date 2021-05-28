package com.github.majdibo.workman.core.base.dao.entity.identifier.generator

import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier

interface BaseIdentifierGenerator<ID : BaseIdentifier> {
    fun generate(session: SessionDelegate, parameters: Map<String, Any>): ID
}

