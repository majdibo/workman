package com.github.majdibo.workman.core.base.dao.entity.identifier.generator

interface SessionDelegate {

    fun generateId(parameters: Map<String, Any>): Any

}
