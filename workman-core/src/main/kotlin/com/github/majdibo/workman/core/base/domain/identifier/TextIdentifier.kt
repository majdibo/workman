package com.github.majdibo.workman.core.base.domain.identifier

data class TextIdentifier(var value: String = "") : BusinessIdentifier {

    override fun nullObject() = of("")

    companion object {
        fun of(value: String) = TextIdentifier().apply { this.value = value }

        fun parse(string: String)= of(string)
    }
}