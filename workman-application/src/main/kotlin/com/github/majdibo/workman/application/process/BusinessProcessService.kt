package com.github.majdibo.workman.application.process

import com.github.majdibo.workman.core.base.domain.identifier.NumericIdentifier
import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.core.base.service.BaseService
import com.github.majdibo.workman.domain.definition.ProcessDefinitions
import com.github.majdibo.workman.domain.definition.task.TaskDefinitionException
import com.github.majdibo.workman.domain.process.BusinessProcess
import com.github.majdibo.workman.domain.process.BusinessProcessBuilder
import com.github.majdibo.workman.domain.process.BusinessProcesses
import com.github.majdibo.workman.domain.process.task.TaskFactory
import java.time.LocalDateTime


class BusinessProcessService(
        private val businessProcesses: BusinessProcesses,
        private val processDefinitions: ProcessDefinitions,
        private val taskFactory: TaskFactory
) : BaseService<BusinessProcess, NumericIdentifier> {

    override fun findAll(): List<BusinessProcess> {
        return businessProcesses.findAll()
    }

    override fun save(entity: BusinessProcess): BusinessProcess {
        //TODO
        return businessProcesses.save(entity)
    }

    override fun delete(id: NumericIdentifier) {
        businessProcesses.delete(id)
    }

    override fun findById(id: NumericIdentifier): BusinessProcess? {
        return businessProcesses.findById(id)
    }

    override fun parseIdentifier(string: String): NumericIdentifier {
        return NumericIdentifier.of(string.toLong())
    }

    fun execute(definitionIdentifier: TextIdentifier, executionTime: LocalDateTime) {
        val definition = processDefinitions.findById(definitionIdentifier)
                ?: throw TaskDefinitionException("definition of id  [${definitionIdentifier.value}] is not found")

        val process = BusinessProcessBuilder(definition, taskFactory)
                .executionTime(executionTime)
                .build()

//        businessProcessService.save(process).execute()
        process.execute()
    }
}