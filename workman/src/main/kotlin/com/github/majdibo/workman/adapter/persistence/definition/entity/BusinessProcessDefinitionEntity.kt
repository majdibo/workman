package com.github.majdibo.workman.adapter.persistence.definition.entity

import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.identifier.StringIdentifier
import com.github.majdibo.workman.core.base.dao.entity.identifier.mapper.StringIdentifierMapper
import com.github.majdibo.workman.domain.definition.BusinessProcessDefinition
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity(name = "BUSINESS_PROCESS_DEFINITION")
class BusinessProcessDefinitionEntity : BaseEntity<BusinessProcessDefinition, StringIdentifier>() {

    @OneToMany(cascade = [CascadeType.ALL])
    val taskTransitions: MutableList<TaskTransitionEntity> = ArrayList()

    override fun toDomain() = BusinessProcessDefinition(StringIdentifierMapper().from(identifier))
            .apply { taskTransitions.forEach { addTransition(it.toDomain()) } }

}
