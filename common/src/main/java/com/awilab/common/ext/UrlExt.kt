package com.awilab.common.ext

import java.io.UnsupportedEncodingException
import java.net.URL
import java.net.URLDecoder

@Throws(UnsupportedEncodingException::class)
fun URL.splitQueryToMap(): Map<String, String> {
	val queryPairs: MutableMap<String, String> = LinkedHashMap()
	val pairs = this.query.split("&").toTypedArray()

	for (pair in pairs) {
		val idx = pair.indexOf("=")

		queryPairs[URLDecoder.decode(pair.substring(0, idx), "UTF-8")] = URLDecoder.decode(
			pair.substring(idx + 1), "UTF-8"
		)
	}
	return queryPairs
}