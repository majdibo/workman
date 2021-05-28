package com.github.majdibo.workman.core.base.dao.entity.identifier

import java.io.Serializable


interface BaseIdentifier : Serializable {
    fun nullObject() : BaseIdentifier

}