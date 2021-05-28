package com.github.majdibo.workman.adapter.endpoint.definition

import com.github.majdibo.workman.adapter.endpoint.definition.resource.BusinessProcessDefinitionResource
import com.github.majdibo.workman.adapter.endpoint.definition.resource.BusinessProcessDefinitionResourceFactory
import com.github.majdibo.workman.adapter.endpoint.definition.resource.BusinessProcessInput
import com.github.majdibo.workman.application.definition.BusinessProcessDefinitionHolder
import com.github.majdibo.workman.application.definition.ProcessDefinitionService
import com.github.majdibo.workman.application.process.BusinessProcessService
import com.github.majdibo.workman.core.base.controller.GenericRestController
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("process-definitions")
class BusinessProcessDefinitionController(
        processDefinitionService: ProcessDefinitionService,
        businessProcessDefinitionRequestFactory: BusinessProcessDefinitionResourceFactory
) : GenericRestController<BusinessProcessDefinitionResource, BusinessProcessDefinitionHolder, TextIdentifier>(processDefinitionService, businessProcessDefinitionRequestFactory){

    @Autowired
    private lateinit var businessProcessService: BusinessProcessService

    @PostMapping("{id}/execute")
    fun execute(request: BusinessProcessInput, @PathVariable id: String){
        businessProcessService.execute(TextIdentifier.of(id), request.executionTime)


    }


}




