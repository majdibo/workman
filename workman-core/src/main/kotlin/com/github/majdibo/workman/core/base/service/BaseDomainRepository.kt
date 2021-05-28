package com.github.majdibo.workman.core.base.service

import com.github.majdibo.workman.core.base.domain.identifier.BusinessIdentifier

interface BaseDomainRepository<T, ID: BusinessIdentifier> {
    fun findAll(): List<T>
    fun save(domain: T): T

    fun delete(id: ID)

    fun findById(id: ID): T?

}