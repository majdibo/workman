package com.github.majdibo.workman.domain

import com.github.majdibo.workman.core.base.domain.identifier.TextIdentifier
import com.github.majdibo.workman.core.workflows.TaskStatus
import com.github.majdibo.workman.domain.definition.BusinessProcessDefinition
import com.github.majdibo.workman.domain.definition.TaskTransition
import com.github.majdibo.workman.domain.definition.task.script.ScriptTaskDefinition
import com.github.majdibo.workman.domain.definition.task.TaskDefinition
import com.github.majdibo.workman.domain.process.BusinessProcessBuilder
import com.github.majdibo.workman.domain.process.task.TaskFactory
import com.github.majdibo.workman.domain.process.task.script.RequestHandler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BusinessProcessBuilderTests {

    private lateinit var taskFactory: TaskFactory

    @BeforeAll
    fun setUp(@Mock requestHandler: RequestHandler) {
        taskFactory = TaskFactory(requestHandler)
    }

    @Test
    fun `build of a valid workflow from definition`() {
        val processDefinition = createBusinessProcessDefinition()

        assertEquals(3, processDefinition.transitions.size)

        val process = BusinessProcessBuilder(processDefinition, taskFactory).build()

        assertEquals(3, process.taskPath.tasks.size) //including a starting task

        val taskStatus = process.execute()

        assertEquals(TaskStatus.SUCCESS_CODE, taskStatus)

    }

    private fun createBusinessProcessDefinition(): BusinessProcessDefinition {
        return BusinessProcessDefinition(TextIdentifier.of("testProcess")).apply {
            val taskDefinitions = mapOf<Int, TaskDefinition>(
                    0 to ScriptTaskDefinition("zero", "query").apply { id = 0 },
                    1 to ScriptTaskDefinition("first", "query").apply { id = 1 },
                    2 to ScriptTaskDefinition("second", "query").apply { id = 2 },
                    3 to ScriptTaskDefinition("third", "query").apply { id = 3 }
            )

            fun getTaskDefinition(key: Int): TaskDefinition = taskDefinitions[key] ?: error("task definition not found")

            addTransition(TaskTransition(from = getTaskDefinition(0), to = getTaskDefinition(1)))
            addTransition(TaskTransition(from = getTaskDefinition(1), to = getTaskDefinition(2)))
            addTransition(TaskTransition(from = getTaskDefinition(1), to = getTaskDefinition(3)))

        }
    }
}