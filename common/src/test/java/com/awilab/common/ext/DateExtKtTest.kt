package com.awilab.common.ext

import com.awilab.testing.ext.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDateTime
import java.util.*

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

	@Test
	@DisplayName("測試 Timestamp to LocalDateTime")
	fun timestampToLocalDateTimeTest() {
		1670890088000.localDateTime.toString() shouldBe "2022-12-13T08:08:08"
	}

	@Test
	@DisplayName("測試 LocalTimeWithoutSec to String")
	fun localTimeWithoutSecToTextTest() {
		localDateTime.toLocalTime().textWithoutSec() shouldBe "08:08"
	}

	@Test
	@DisplayName("測試 LocalTime 轉檔名")
	fun localTimeFormatToFileNameTest() {
		println("============= ${localDateTime.toLocalTime().formatToLogFileName()}")
		localDateTime.toLocalTime().formatToLogFileName() shouldBe "0808"
	}

	@Test
	@DisplayName("測試 LocalDateTime to String")
	fun localDateTimeToTextTest() {
		val localDateTimeTextZh = localDateTime.text(Locale.CHINESE)
		localDateTimeTextZh shouldBe "2022/12/13 08:08:08"
		val localDateTimeTextEn = localDateTime.text(Locale.ENGLISH)
		localDateTimeTextEn shouldBe "Dec/13/2022 08:08:08"
	}

	@Test
	@DisplayName("測試 LocalDate to String")
	fun localDateTimeFormatYMD() {
		val localDate = localDateTime.toLocalDate()
		val localDateTimeZh = localDate.text(Locale.CHINESE)
		localDateTimeZh shouldBe "2022/12/13"
		val localDateTimeEn = localDate.text(Locale.ENGLISH)
		localDateTimeEn shouldBe "Dec/13/2022"
	}

	@Test
	@DisplayName("測試 Millisecond to Second")
	fun millisecondToSecondTest() {
		1670890088000L.millisecondToSecond shouldBe 1670890088
	}

	@Test
	@DisplayName("測試 Second to Millisecond")
	fun secondToMillisecondTest() {
		1670890088L.secondToMillisecond shouldBe 1670890088000
	}

	@Test
	@DisplayName("測試是否在區間內-Second")
	fun secondIsBetweenTest() {
		val startDateTime = LocalDateTime.of(2022, 12, 13, 8, 8, 7)
		val endDateTime = LocalDateTime.of(2022, 12, 13, 8, 8, 9)

		checkIsBetween(startDateTime, endDateTime)
	}

	@Test
	@DisplayName("測試是否在區間內-Minute")
	fun minuteIsBetweenTest() {
		val startDateTime = LocalDateTime.of(2022, 12, 13, 8, 7, 8)
		val endDateTime = LocalDateTime.of(2022, 12, 13, 8, 9, 8)

		checkIsBetween(startDateTime, endDateTime)
	}

	@Test
	@DisplayName("測試是否在區間內-Hour")
	fun hourIsBetweenTest() {
		val startDateTime = LocalDateTime.of(2022, 12, 13, 7, 8, 8)
		val endDateTime = LocalDateTime.of(2022, 12, 13, 9, 8, 8)

		checkIsBetween(startDateTime, endDateTime)
	}

	@Test
	@DisplayName("測試是否在區間內-Day")
	fun dayIsBetweenTest() {
		val startDateTime = LocalDateTime.of(2022, 12, 12, 8, 8, 8)
		val endDateTime = LocalDateTime.of(2022, 12, 14, 8, 8, 8)

		checkIsBetween(startDateTime, endDateTime)
	}

	@Test
	@DisplayName("測試是否在區間內-Month")
	fun monthIsBetweenTest() {
		val startDateTime = LocalDateTime.of(2022, 11, 13, 8, 8, 8)
		val endDateTime = LocalDateTime.of(2023, 1, 13, 8, 8, 8)

		checkIsBetween(startDateTime, endDateTime)
	}

	@Test
	@DisplayName("測試是否在區間內-Year")
	fun yearIsBetweenTest() {
		val startDateTime = LocalDateTime.of(2021, 12, 13, 8, 8, 8)
		val endDateTime = LocalDateTime.of(2023, 12, 13, 8, 8, 8)

		checkIsBetween(startDateTime, endDateTime)
	}

	@Test
	@DisplayName("測試 ISO to LocalDateTime")
	fun isoStringToLocalDateTimeTest() {
		val dateTime = "2022-12-13T08:08:08+02:00".localDateTimeFromISO

		dateTime.year shouldBe 2022
		dateTime.month.value shouldBe 12
		dateTime.dayOfMonth shouldBe 13
		dateTime.dayOfWeek.value shouldBe 2
		dateTime.hour shouldBe 8
		dateTime.minute shouldBe 8
		dateTime.second shouldBe 8
	}

	@Test
	@DisplayName("測試 String to LocalDate")
	fun stringToLocalDateTest() {
		val dateTime = "2022-12-13".localDateFromISO

		dateTime.year shouldBe 2022
		dateTime.month.value shouldBe 12
		dateTime.dayOfMonth shouldBe 13
	}

	@Test
	@DisplayName("測試日期是否在3天內")
	fun checkFileBetween3Days() {
		val dateTimeNow = "2022-12-14".localDateFromISO
		val fileDateTime = "2022-12-13".localDateFromISO
		val dateTimeStart = fileDateTime.minusDays(3)

		dateTimeNow.isAfter(dateTimeStart) shouldBe true
		dateTimeNow.isBefore(dateTimeStart) shouldBe false
	}

	private fun checkIsBetween(startDateTime: LocalDateTime, endDateTime: LocalDateTime) {
		localDateTime.isBetween(
			startDateTime = startDateTime,
			endDateTime = endDateTime
		) shouldBe true

		localDateTime.isBetween(
			startDateTime = endDateTime,
			endDateTime = startDateTime
		) shouldBe false
	}
}