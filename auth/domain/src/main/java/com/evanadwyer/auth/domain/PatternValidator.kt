package com.evanadwyer.auth.domain

interface PatternValidator {

    fun matches(value: String): Boolean
}