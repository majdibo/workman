package com.github.majdibo.workman.adapter.endpoint.definition.task

import com.github.majdibo.workman.adapter.endpoint.definition.task.resource.script.ScriptTaskDefinitionResource
import com.github.majdibo.workman.adapter.endpoint.definition.task.resource.script.ScriptTaskDefinitionResourceFactory
import com.github.majdibo.workman.application.definition.task.ScriptTaskDefinitionService
import com.github.majdibo.workman.core.base.controller.GenericRestController
import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("task-definitions/scripts")
class ScriptTaskDefinitionController(
        taskDefinitionService: ScriptTaskDefinitionService,
        scriptTaskDefinitionRequestFactory: ScriptTaskDefinitionResourceFactory
) : GenericRestController<ScriptTaskDefinitionResource, ScriptTaskDefinition, NumericIdentifier>(taskDefinitionService, scriptTaskDefinitionRequestFactory)
