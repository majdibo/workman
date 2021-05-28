package com.github.majdibo.workman.adapter.endpoint.definition.resource

import com.github.majdibo.workman.application.definition.BusinessProcessDefinitionHolder
import com.github.majdibo.workman.application.definition.TaskTransitionReferenceHolder
import com.github.majdibo.workman.core.base.controller.resource.BaseResourceFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BusinessProcessDefinitionResourceFactory : BaseResourceFactory<BusinessProcessDefinitionHolder, BusinessProcessDefinitionResource> {
    @Autowired
    private lateinit var taskTransitionFactory: TaskTransitionFactory


    override fun of(domain: BusinessProcessDefinitionHolder): BusinessProcessDefinitionResource {
        val transitionResources = domain.transitions.map { taskTransitionFactory.of(it) }

        return BusinessProcessDefinitionResource(domain.name.value, transitionResources)
    }

}

@Service
class TaskTransitionFactory : BaseResourceFactory<TaskTransitionReferenceHolder, TaskTransitionResource> {

    override fun of(domain: TaskTransitionReferenceHolder): TaskTransitionResource {

        return TaskTransitionResource(domain.from.value, domain.to.value, domain.waitCompletion)
    }

}
