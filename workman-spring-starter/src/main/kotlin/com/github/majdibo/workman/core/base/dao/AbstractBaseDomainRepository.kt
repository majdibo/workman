@file:Suppress("SpringJavaInjectionPointsAutowiringInspection")

package com.github.majdibo.workman.core.base.dao

import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.BaseEntityFactory
import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier
import com.github.majdibo.workman.core.base.dao.entity.identifier.mapper.IdentifierMapper
import com.github.majdibo.workman.core.base.domain.identifier.BusinessIdentifier
import com.github.majdibo.workman.core.base.service.BaseDomainRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
abstract class AbstractBaseDomainRepository<T, BID : BusinessIdentifier, E : BaseEntity<T, ID>, ID : BaseIdentifier> : BaseDomainRepository<T, BID> {

    @Autowired
    private lateinit var repository: BaseDaoRepository<E, ID>

    @Autowired
    private lateinit var factory: BaseEntityFactory<T, E>

    @Autowired
    private lateinit var identifierMapper: IdentifierMapper<ID, BID>

    override fun findAll(): List<T> {
        return repository.findAll().map { (it).toDomain() }
    }

    override fun save(domain: T): T {
        val entity = factory.of(domain)
        return repository.save(entity).toDomain()
    }

    override fun delete(id: BID) {
        repository.deleteById(identifierMapper.from(id))
    }

    override fun findById(id: BID): T? {
        val optional = repository.findById(identifierMapper.from(id))
        return if (optional.isPresent) optional.get().toDomain() else null
    }

}
