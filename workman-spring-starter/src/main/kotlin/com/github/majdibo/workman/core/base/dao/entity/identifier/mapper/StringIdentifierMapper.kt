package com.github.majdibo.workman.core.base.dao.entity.identifier.mapper

import com.github.majdibo.workman.core.base.dao.entity.identifier.StringIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import org.springframework.stereotype.Service

@Service
class StringIdentifierMapper: IdentifierMapper<StringIdentifier, TextIdentifier> {

    override fun from(id: TextIdentifier): StringIdentifier {
        return StringIdentifier.of(id.value)
    }

    override fun from(id: StringIdentifier): TextIdentifier {
        return TextIdentifier.of(id.value)
    }
}