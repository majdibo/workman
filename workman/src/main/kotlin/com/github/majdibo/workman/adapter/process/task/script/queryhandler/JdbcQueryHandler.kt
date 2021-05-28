package com.github.majdibo.workman.adapter.process.task.script.queryhandler

import com.github.majdibo.workman.adapter.process.task.script.QueryHandler
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class JdbcQueryHandler(val jdbcTemplate: JdbcTemplate) : QueryHandler {
    override fun execute(query: String) = jdbcTemplate.execute(query)
}