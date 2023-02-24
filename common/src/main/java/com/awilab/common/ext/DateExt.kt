package com.awilab.common.ext

import com.awilab.common.DateTimeFormatPattern.DATE_FORMAT
import com.awilab.common.DateTimeFormatPattern.DATE_FORMAT_EN
import com.awilab.common.DateTimeFormatPattern.DATE_TIME_FORMAT
import com.awilab.common.DateTimeFormatPattern.DATE_TIME_FORMAT_EN
import com.awilab.common.DateTimeFormatPattern.TIME_FORMAT_H_M
import com.awilab.common.DateTimeFormatPattern.TIME_FORMAT_H_M_FILE_NAME
import org.threeten.bp.DateTimeUtils
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import java.sql.Timestamp
import java.util.Locale

val LocalDateTime.timestamp: Long
    get() = DateTimeUtils.toSqlTimestamp(this).time

val String.localDateTimeFromISO: LocalDateTime
    get() = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)

val String.localDateFromISO: LocalDate
    get() = LocalDate.parse(this, DateTimeFormatter.ISO_DATE)

val Long.millisecondToSecond: Long
    get() = this / 1000

val Long.secondToMillisecond: Long
    get() = this * 1000

val Long.localDateTime: LocalDateTime
    get() = DateTimeUtils.toLocalDateTime(Timestamp(this))

fun LocalDateTime.isBetween(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Boolean =
    this.isAfter(startDateTime) && this.isBefore(endDateTime)

/**
 * @return
 * 英文: Dec/13/2022 08:08:08
 * 其他: 2022/12/13 08:08:08
 */
fun LocalDateTime.text(locale: Locale = Locale.CHINESE): String {
    val pattern = when (locale.language) {
        "en" -> DATE_TIME_FORMAT_EN
        else -> DATE_TIME_FORMAT
    }
    return format(DateTimeFormatter.ofPattern(pattern, locale))
}

/**
 * @return
 * 英文: Dec/13/2022
 * 其他: 2022/12/13
 */
fun LocalDate.text(locale: Locale = Locale.CHINESE): String {
    val pattern = when (locale.language) {
        "en" -> DATE_FORMAT_EN
        else -> DATE_FORMAT
    }
    return format(DateTimeFormatter.ofPattern(pattern, locale))
}

fun LocalTime.textWithoutSec(): String = format(DateTimeFormatter.ofPattern(TIME_FORMAT_H_M))

// 因為 FileName 不能含有 ":" 故 Format 成底線
// See more: https://superuser.com/a/693819
fun LocalTime.formatToLogFileName(): String =
    format(DateTimeFormatter.ofPattern(TIME_FORMAT_H_M_FILE_NAME))
