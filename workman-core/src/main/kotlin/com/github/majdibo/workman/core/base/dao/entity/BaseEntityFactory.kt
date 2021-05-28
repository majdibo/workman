package com.github.majdibo.workman.core.base.dao.entity

import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier

interface BaseEntityFactory<T, E : AbstractBaseEntity<T, out BaseIdentifier>> {
    fun of(domain: T): E

}
