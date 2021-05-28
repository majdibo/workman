package com.github.majdibo.workman.adapter.persistence.process.entity

import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.domain.process.task.BusinessTask
import javax.persistence.Entity

@Entity(name = "BUSINESS_TASK")
class BusinessTaskEntity : BaseEntity<BusinessTask, LongIdentifier>() {
    override fun toDomain(): BusinessTask {
        TODO("Not yet implemented")
    }

}
