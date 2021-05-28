package com.github.majdibo.workman.core.workflows

import com.github.majdibo.workman.core.workflows.tasks.ErrorTask
import com.github.majdibo.workman.core.workflows.tasks.NamedTask
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WorkflowTest {

    @Test
    fun `check if execution is ok`() {
        val workflow = {
            Workflow(
                    TaskPath<Task>()
                            .addTask(NamedTask("task 1"))
                            .addTask(NamedTask("task 2"))
                            .addTask(NamedTask("task 3"))
            )

        }()

        val taskStatus = workflow.execute()
        Assertions.assertEquals(TaskStatus.SUCCESS_CODE, taskStatus)

    }

    @Test
    fun `check if execution is unsuccessful`() {
        val workflow = {
            Workflow(
                    TaskPath<Task>()
                            .addTask(NamedTask("task 1"))
                            .addTask(ErrorTask("task 2"))
                            .addTask(NamedTask("task 3"))
                            .addTask(NamedTask("task 4"))
            )

        }()

        val taskStatus = workflow.execute()
        Assertions.assertEquals(TaskStatus.ERROR_CODE, taskStatus)

    }

}
