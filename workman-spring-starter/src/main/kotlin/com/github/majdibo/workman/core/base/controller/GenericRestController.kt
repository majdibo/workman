package com.github.majdibo.workman.core.base.controller

import com.github.majdibo.workman.core.base.controller.resource.BaseResource
import com.github.majdibo.workman.core.base.controller.resource.BaseResourceFactory
import com.github.majdibo.workman.core.base.domain.identifier.BusinessIdentifier
import com.github.majdibo.workman.core.base.service.BaseService
import org.springframework.web.bind.annotation.*

open class GenericRestController<R : BaseResource<T>, T, ID : BusinessIdentifier>(
    service: BaseService<T, ID>,
    factory: BaseResourceFactory<T, R>
) : AbstractGenericRestController<R, T, ID>(service, factory) {

    @GetMapping
    override fun list(): List<R> {
        return super.list()
    }

    @PostMapping
    override fun create(@RequestBody request: R): R {
        return super.create(request)
    }

    @PutMapping
    override fun update(@RequestBody request: R): R {
        return super.update(request)
    }

    @DeleteMapping("{id}")
    override fun delete(@PathVariable id: String) {
        super.delete(id)
    }

    @GetMapping("{id}")
    override fun get(@PathVariable id: String): R? {
        return super.get(id)
    }
}