package com.github.majdibo.workman.core.base.dao

import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseDaoRepository<E: BaseEntity<*, ID>, ID: BaseIdentifier> : JpaRepository<E, ID>