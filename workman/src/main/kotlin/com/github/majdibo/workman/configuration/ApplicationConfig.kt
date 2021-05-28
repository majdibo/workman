package com.github.majdibo.workman.configuration

import com.github.majdibo.workman.application.definition.ProcessDefinitionService
import com.github.majdibo.workman.application.definition.task.ScriptTaskDefinitionService
import com.github.majdibo.workman.application.process.BusinessProcessService
import com.github.majdibo.workman.domain.definition.ProcessDefinitions
import com.github.majdibo.workman.domain.definition.task.TaskDefinitions
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinitions
import com.github.majdibo.workman.domain.process.BusinessProcesses
import com.github.majdibo.workman.domain.process.task.TaskFactory
import com.github.majdibo.workman.domain.process.task.script.RequestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun processDefinitionService(processDefinitions: ProcessDefinitions,
                                 taskDefinitions: TaskDefinitions) = ProcessDefinitionService(processDefinitions, taskDefinitions)

    @Bean
    fun businessProcessService(businessProcesses: BusinessProcesses,
                               processDefinitions: ProcessDefinitions,
                               taskFactory: TaskFactory) = BusinessProcessService(businessProcesses, processDefinitions, taskFactory)

    @Bean
    fun taskDefinitionService(scriptTaskDefinitions: ScriptTaskDefinitions) = ScriptTaskDefinitionService(scriptTaskDefinitions)

    @Bean
    fun taskFactory(requestHandler: RequestHandler) = TaskFactory(requestHandler)

}