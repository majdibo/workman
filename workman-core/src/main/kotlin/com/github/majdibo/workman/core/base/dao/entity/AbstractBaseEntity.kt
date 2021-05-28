package com.github.majdibo.workman.core.base.dao.entity

import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier
import java.io.Serializable

abstract class AbstractBaseEntity<T, ID : BaseIdentifier> : Serializable {

    open lateinit var identifier: ID

    abstract fun toDomain(): T

}
