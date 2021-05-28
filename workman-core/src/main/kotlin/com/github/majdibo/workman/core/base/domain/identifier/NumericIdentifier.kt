package com.github.majdibo.workman.core.base.domain.identifier

data class NumericIdentifier(
        var value: Long = -1
) : BusinessIdentifier {

    override fun nullObject() = of(-1)


    companion object {
        fun of(value: Long): NumericIdentifier {
            return NumericIdentifier().apply { this.value = value }
        }

        fun parse(string: String)= of(string.toLong())
    }

}