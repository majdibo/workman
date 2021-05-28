package com.github.majdibo.workman.core.base.dao.entity.identifier.generator

import org.hibernate.Session

class SessionDelegateAdapter(private val session: Session): SessionDelegate {
    override fun generateId(parameters: Map<String, Any>) : Any {
        return (session.createNativeQuery(parameters[BaseEntitySequenceIdentifier.SEQUENCE_NEXT_VALUE] as String).uniqueResult() as Number).toLong()
    }
}