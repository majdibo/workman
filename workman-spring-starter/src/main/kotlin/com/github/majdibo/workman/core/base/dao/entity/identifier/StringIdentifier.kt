package com.github.majdibo.workman.core.base.dao.entity.identifier

import com.github.majdibo.workman.core.base.dao.entity.identifier.generator.BaseIdentifierGenerator
import com.github.majdibo.workman.core.base.dao.entity.identifier.generator.IdentifierGeneratorHolder
import com.github.majdibo.workman.core.base.dao.entity.identifier.generator.SessionDelegate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
@IdentifierGeneratorHolder(generator = StringIdentifierGenerator::class)
data class StringIdentifier(@Column(name = "ID") var value: String = "") : BaseIdentifier {

    override fun nullObject() = of("")

    companion object {
        fun of(value: String) = StringIdentifier().apply { this.value = value }
    }
}


class StringIdentifierGenerator : BaseIdentifierGenerator<StringIdentifier> {
    override fun generate(session: SessionDelegate, parameters: Map<String, Any>): StringIdentifier {
        return StringIdentifier().apply { value = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
    }
}
