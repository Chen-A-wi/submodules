package com.awilab.network

import com.awilab.common.ext.fromType

enum class ErrorType {
	UNKNOWN_ERROR;

	val code
		get() = when (this) {
			UNKNOWN_ERROR -> -1
		}

	val resString
		get() = when (this) {
			UNKNOWN_ERROR -> "Unknown error"
		}

	companion object {
		fun fromCode(code: Int?): ErrorType = ErrorType::code.fromType(code, UNKNOWN_ERROR)
	}
}