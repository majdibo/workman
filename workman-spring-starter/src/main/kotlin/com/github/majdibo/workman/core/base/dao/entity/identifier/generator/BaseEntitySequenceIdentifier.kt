package com.github.majdibo.workman.core.base.dao.entity.identifier.generator

import com.github.majdibo.workman.core.base.dao.entity.BaseEntity
import com.github.majdibo.workman.core.base.dao.entity.identifier.BaseIdentifier
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.Configurable
import org.hibernate.id.IdentifierGenerator
import org.hibernate.id.enhanced.SequenceStyleGenerator
import org.hibernate.internal.util.config.ConfigurationHelper
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.Type
import java.io.Serializable
import java.util.*
import kotlin.reflect.full.createInstance

class BaseEntitySequenceIdentifier : IdentifierGenerator, Configurable {
    private lateinit var sequenceCallSyntax: String

    override fun generate(session: SharedSessionContractImplementor, obj: Any): Serializable {

        if (obj !is BaseEntity<*, out BaseIdentifier>) throw IllegalArgumentException("object should be of BaseEntity type , found ${obj.javaClass}")

        val identifier = obj.identifier

        if (identifier == identifier.nullObject()) {
            val identifierGeneratorHolder = identifier.javaClass.getAnnotation(IdentifierGeneratorHolder::class.java)
            if (identifierGeneratorHolder != null) {
                val generator = identifierGeneratorHolder.generator.createInstance()

                val parameters = mapOf(
                        SEQUENCE_NEXT_VALUE to sequenceCallSyntax,
                        BASE_ENTITY to obj
                )

                val temporarySession = session.factory.openTemporarySession()
                return generator.generate(SessionDelegateAdapter(temporarySession), parameters).also {
                    temporarySession.close()
                }
            }
        }

        return identifier

    }

    override fun configure(type: Type, params: Properties, serviceRegistry: ServiceRegistry) {
        val preferSequencePerEntity = ConfigurationHelper.getBoolean(SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, params, false)

        val sequenceName = if (preferSequencePerEntity) {
            val sequencePerEntitySuffix = ConfigurationHelper.getString(SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, params, SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX)
            params.getProperty(IdentifierGenerator.JPA_ENTITY_NAME) + sequencePerEntitySuffix
        } else SequenceStyleGenerator.DEF_SEQUENCE_NAME

        sequenceCallSyntax = serviceRegistry.getService(JdbcEnvironment::class.java).dialect.getSequenceNextValString(ConfigurationHelper.getString(SequenceStyleGenerator.SEQUENCE_PARAM, params, sequenceName))
    }


    companion object {
        const val SEQUENCE_NEXT_VALUE = "SEQUENCE_CALL_SYNTAX"
        const val BASE_ENTITY = "BASE_ENTITY"

        const val CLASS_NAME = "com.github.majdibo.workman.core.base.dao.entity.identifier.generator.BaseEntitySequenceIdentifier"
    }
}


