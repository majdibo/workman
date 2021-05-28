package com.github.majdibo.workman.adapter.persistence.definition.task.script

import com.github.majdibo.workman.adapter.persistence.definition.task.script.entity.ScriptTaskDefinitionEntity
import com.github.majdibo.workman.core.base.dao.AbstractBaseDomainRepository
import com.github.majdibo.workman.core.base.dao.BaseDaoRepository
import com.github.majdibo.workman.core.base.dao.entity.identifier.LongIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinitions
import org.springframework.stereotype.Repository

@Repository
class ScriptTaskDefinitionRepository : AbstractBaseDomainRepository<ScriptTaskDefinition, NumericIdentifier, ScriptTaskDefinitionEntity, LongIdentifier>(), ScriptTaskDefinitions


interface ScriptTaskDefinitionDaoRepository : BaseDaoRepository<ScriptTaskDefinitionEntity, LongIdentifier>
