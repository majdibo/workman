package com.github.majdibo.workman.core.base.controller

import com.github.majdibo.workman.core.base.controller.resource.BaseResource
import com.github.majdibo.workman.core.base.controller.resource.BaseResourceFactory
import com.github.majdibo.workman.core.base.domain.identifier.BusinessIdentifier
import com.github.majdibo.workman.core.base.service.BaseService

abstract class AbstractGenericRestController<R : BaseResource<T>, T, ID: BusinessIdentifier>(
        private val service: BaseService<T, ID>,
        private val factory: BaseResourceFactory<T, R>
) {

    open fun list(): List<R> {
        return service.findAll().map { factory.of(it) }
    }

    open fun create( request: R): R {
        return service.save(request.to()).let { factory.of(it) }
    }

    open fun update( request: R): R {
        return service.save(request.to()).let { factory.of(it) }
    }

    open fun delete(id: String) {
        val identifier = service.parseIdentifier(id)
        service.delete(identifier)
    }

    open fun get( id: String): R? {
        val identifier = service.parseIdentifier(id)

        return service.findById(identifier)?.let { factory.of(it) }
    }
}