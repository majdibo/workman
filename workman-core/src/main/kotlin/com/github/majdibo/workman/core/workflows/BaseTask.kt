package com.github.majdibo.workman.core.workflows

import com.github.majdibo.workman.core.workflows.TaskStatus.ERROR_CODE
import com.github.majdibo.workman.core.workflows.TaskStatus.SUCCESS_CODE
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletableFuture.supplyAsync

abstract class BaseTask : Task {
    protected val log: Logger = LoggerFactory.getLogger(javaClass)

    var parallelTasks = ArrayList<Task>()

    lateinit var startingTime: LocalDateTime
    lateinit var completedTime: LocalDateTime

    override fun addParallelTasks(task: Task) = apply { parallelTasks.add(task) }

    override fun execute(): TaskStatus {
        try {
            startingTime = LocalDateTime.now()
            process()
            completedTime = LocalDateTime.now()

            val futuresMap = executeParallelTasks()

            if (futuresMap.values.any { it.get() != SUCCESS_CODE })
                throw TaskExecutionException("Problem occurred while executing task")
        } catch (e: WorkflowException) {
            log.error("an error occurred", e)
            return ERROR_CODE
        }

        return SUCCESS_CODE
    }

    private fun executeParallelTasks(): Map<String, CompletableFuture<TaskStatus>> {
        val futuresMap: MutableMap<String, CompletableFuture<TaskStatus>> = HashMap()
        parallelTasks.forEach { futuresMap[UUID.randomUUID().toString()] = supplyAsync(it::execute) }
        return futuresMap
    }

    protected abstract fun process()
}

