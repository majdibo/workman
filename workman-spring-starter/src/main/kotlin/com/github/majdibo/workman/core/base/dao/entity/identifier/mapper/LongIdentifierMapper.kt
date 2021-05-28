package com.github.majdibo.workman.core.base.dao.entity.identifier.mapper

import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import org.springframework.stereotype.Service

@Service
class LongIdentifierMapper: IdentifierMapper<LongIdentifier, NumericIdentifier> {
    override fun from(id: NumericIdentifier): LongIdentifier {
        return LongIdentifier.of(id.value)
    }

    override fun from(id: LongIdentifier): NumericIdentifier {
        return NumericIdentifier.of(id.value)
    }
}

