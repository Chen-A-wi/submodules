package com.awilab.common.ext

import com.awilab.testing.ext.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDateTime

internal class DateExtKtTest {
	private lateinit var localDateTime: LocalDateTime

	@BeforeEach
	fun setUp() {
		localDateTime = LocalDateTime.of(2022, 12, 13, 8, 8, 8)
	}

	@Test
	@DisplayName("測試 LocalDateTime to Timestamp")
	fun localDateTimeToTimestampTest() {
		localDateTime.timestamp shouldBe 1670890088000
	}
}