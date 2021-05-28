package com.github.majdibo.workman.adapter.endpoint.definition.resource

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

class BusinessProcessInput(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        val executionTime: LocalDateTime = LocalDateTime.now()
)
