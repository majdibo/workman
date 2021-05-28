package com.github.majdibo.workman.core.base.dao.entity.identifier

import com.github.majdibo.workman.core.base.dao.entity.identifier.generator.BaseIdentifierGenerator
import com.github.majdibo.workman.core.base.dao.entity.identifier.generator.IdentifierGeneratorHolder
import com.github.majdibo.workman.core.base.dao.entity.identifier.generator.SessionDelegate
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
@IdentifierGeneratorHolder(generator = LongIdentifierGenerator::class)
data class LongIdentifier(
        @Column(name = "ID")
        var value: Long = -1
) : BaseIdentifier {

    override fun nullObject() = of(-1)

    companion object {
        fun of(value: Long): LongIdentifier {
            return LongIdentifier().apply { this.value = value }
        }
    }

}

class LongIdentifierGenerator : BaseIdentifierGenerator<LongIdentifier> {
    override fun generate(session: SessionDelegate, parameters: Map<String, Any>): LongIdentifier {
        return LongIdentifier().apply { value = session.generateId(parameters) as Long }
    }
}