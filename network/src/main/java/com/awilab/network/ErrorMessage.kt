package com.awilab.network

import android.content.Context

data class ErrorMessage(
	val errorCode: Int = -1,
	val errorMsg: String = ""
) {
	fun message(context: Context): String {
		return if (errorCode == -1) {
			"(${ErrorType.fromCode(errorCode).resString}) $errorMsg"
		} else {
			"($errorCode) $errorMsg"
		}
	}
}