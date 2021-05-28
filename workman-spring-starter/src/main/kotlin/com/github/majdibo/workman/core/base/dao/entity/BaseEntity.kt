package com.github.majdibo.workman.core.base.dao.entity

import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier
import com.github.majdibo.workman.core.base.dao.entity.identifier.generator.BaseEntitySequenceIdentifier
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import javax.persistence.EmbeddedId
import javax.persistence.GeneratedValue
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity<T, ID : BaseIdentifier> : AbstractBaseEntity<T, ID>() {

    @EmbeddedId
    @GenericGenerator(name = "assigned-sequence", strategy = BaseEntitySequenceIdentifier.CLASS_NAME,
            parameters = [Parameter(name = "prefer_sequence_per_entity", value = "true")])
    @GeneratedValue(generator = "assigned-sequence")
    override lateinit var identifier: ID

}
