package com.github.majdibo.workman.core.base.dao.entity.identifier.generator

import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier
import kotlin.reflect.KClass

annotation class IdentifierGeneratorHolder(
        val generator: KClass<out BaseIdentifierGenerator<out BaseIdentifier>>
)