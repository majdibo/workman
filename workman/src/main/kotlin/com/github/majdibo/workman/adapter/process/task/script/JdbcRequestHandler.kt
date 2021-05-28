package com.github.majdibo.workman.adapter.process.task.script

import com.github.majdibo.workman.domain.process.task.script.RequestHandler
import com.github.majdibo.workman.domain.process.task.script.ScriptTaskException
import org.apache.commons.lang.text.StrSubstitutor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JdbcRequestHandler(private val queryHandler: QueryHandler) : RequestHandler {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)


    @Transactional
    override fun execute(script: String, parameters: Map<String, Any>) {
        getRequests(script).forEach {
            executeQuery(it, parameters)
        }
    }

    private fun executeQuery(script: String, parameters: Map<String, Any>) {
        val query = replaceParams(script, parameters)
        logger.trace("execution of request : [$query]")
        try {
            queryHandler.execute(query)
        } catch (ex: Exception) {
            throw ScriptTaskException("Error while executing request : [$query]", ex)
        }
    }

    /**
     * @param query query to subtitue parameters
     * @param params list of parameters
     * @return substitute parameters and return request
     */
    private fun replaceParams(query: String, params: Map<String, Any>): String {
        val parameters = HashMap<String, Any>(params)

        return StrSubstitutor(parameters, "\${", "}").replace(query)
    }

    /**
     * @param requestScript: the script to split
     * @return the list of requests and remove all comments
     *
     * disclaimer : this does not support comment with semi-columns
     */
    private fun getRequests(requestScript: String): List<String> {
        val commentsPattern = "(/\\*.*\\*/)|(--.*)"
        val newLinePattern = "(\r\n|\r|\n)"
        val replacement = " "
        val delimiters = ";"

        return commentsPattern.toRegex().replace(requestScript, replacement)
                .run { newLinePattern.toRegex().replace(this, replacement) }
                .split(delimiters)
                .map { commentsPattern.toRegex().replace(it, replacement).trim() }
                .filter { it.isNotBlank() }
    }
}