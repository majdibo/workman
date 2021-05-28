package com.github.majdibo.workman.adapter.process.task.script

import com.github.majdibo.workman.adapter.process.task.script.queryhandler.JdbcQueryHandler
import com.github.majdibo.workman.domain.process.task.script.RequestHandler
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.jdbc.core.JdbcTemplate

@ExtendWith(MockitoExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JdbcRequestHandlerTest {

    lateinit var requestHandler: RequestHandler
    lateinit var queryHandler: QueryHandler

    @BeforeEach
    fun setUp() {
        queryHandler = mock(JdbcQueryHandler::class.java)
        requestHandler = JdbcRequestHandler(queryHandler)
    }

    @Test
    fun `check script is substituted  with parameters`() {
        `when`(queryHandler.execute(ArgumentMatchers.anyString())).then {
            Assertions.assertEquals("select * from A where B = C", it.getArgument(0))
        }

        requestHandler.execute("select * from ${'$'}{A_PARAM} where ${'$'}{B_PARAM} = ${'$'}{C_PARAM}",
                mapOf("A_PARAM" to "A", "B_PARAM" to "B", "C_PARAM" to "C"))
    }


    @Test
    fun `script splitted in many request`() {
        requestHandler.execute("""select * from A; 
            ---aaa:;,,;;comment should not be counted; ;
            select * from A;
            /* comment 
                    should not 
                    be counted */select * from A; 
            
        """.trimIndent(), emptyMap())
        verify(queryHandler, times(3)).execute(ArgumentMatchers.anyString())

    }
}