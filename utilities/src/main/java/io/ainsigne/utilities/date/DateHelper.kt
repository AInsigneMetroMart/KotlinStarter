package io.ainsigne.utilities.date

import java.util.*

object DateHelper

/**
 * AU abbreviates month names to end with dot. US is a more traditional way
 */
private val local by lazy { Locale("en", "US") }
private val dateFormatterProvider by lazy { SingleDateFormatterProvider() }

fun Date.prettyPrint(
    dateFormat: DateFormat,
    timeZone: TimezoneFormat = TimezoneFormat.DEVICE
): String {
    val buildDateFormatter = dateFormatterProvider.get(dateFormat, local, timeZone)
    return synchronized(buildDateFormatter) { buildDateFormatter.format(this) }
}

fun Calendar.prettyPrint(
    dateFormat: DateFormat,
    timeZone: TimezoneFormat = TimezoneFormat.DEVICE
): String {
    return time.prettyPrint(dateFormat, timeZone)
}

fun String.toDate(
    dateFormat: DateFormat,
    timeZone: TimezoneFormat = TimezoneFormat.DEVICE
): Date {
    return toDateOrNull(dateFormat, timeZone)
        ?: throw IllegalArgumentException("Can not parse $this with ${dateFormat.pattern}")
}

fun String.toDateOrNull(
    dateFormat: DateFormat,
    timeZone: TimezoneFormat = TimezoneFormat.DEVICE
): Date? {
    val buildDateFormatter = dateFormatterProvider.get(dateFormat, local, timeZone)
    return synchronized(buildDateFormatter) {
        try {
            buildDateFormatter.parse(this)
        } catch (e: Exception) {
            null
        }
    }
}