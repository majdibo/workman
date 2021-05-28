package com.github.majdibo.workman.core.base.controller.resource

interface BaseResourceFactory<T, R> {
    fun of(domain: T): R

}
