package com.github.majdibo.workman.adapter.persistence.process.entity

import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.domain.process.BusinessProcess
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity(name = "BUSINESS_PROCESS")
class BusinessProcessEntity : BaseEntity<BusinessProcess, LongIdentifier>() {
    @Column
    lateinit var processDefinition: TextIdentifier
    @Column
    lateinit var executionDate: LocalDateTime


    @OneToMany
    lateinit var taskPath: List<BusinessTaskEntity>

    override fun toDomain(): BusinessProcess {
       TODO()
    }

}
