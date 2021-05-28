package com.github.majdibo.workman.core.base.service

import com.github.majdibo.workman.core.base.domain.identifier.BusinessIdentifier

interface BaseService<T, ID: BusinessIdentifier> {
    fun findAll(): List<T>

    fun save(entity: T): T

    fun delete(id: ID)

    fun findById(id: ID): T?

    fun parseIdentifier(string: String) : ID

}