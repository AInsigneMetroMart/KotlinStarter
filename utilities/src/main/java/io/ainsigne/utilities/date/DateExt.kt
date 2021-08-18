package io.ainsigne.utilities.date

import java.util.*
import java.util.Calendar.*

object DateExt

/**
 * AU abbreviates month names to end with dot. US is a more traditional way
 */
val displayLocal by lazy { Locale("en", "US") }

fun Date.toCalendar(timezone: TimeZone = TimezoneFormat.DEVICE.timeZone): Calendar {
    return getInstance(timezone).apply { this.time = this@toCalendar }
}

fun Date.getMonthOfYear(timezone: TimeZone = TimezoneFormat.DEVICE.timeZone): Int {
    return getInstance(timezone).apply { this.time = this@getMonthOfYear }.getMonthOfYear()
}

fun Date.getDayOfMonth(timezone: TimeZone = TimezoneFormat.DEVICE.timeZone): Int {
    return getInstance(timezone).apply { this.time = this@getDayOfMonth }.getDayOfMonth()
}

fun Calendar.copy(): Calendar {
    return getInstance(this.timeZone).apply { time = this@copy.time }
}

fun Date.addDays(days: Int): Date {
    return getInstance(displayLocal)
        .apply {
            time = this@addDays
            add(DAY_OF_YEAR, days)
        }
        .time
}

fun Date.addMonths(months: Int): Date {
    return getInstance(displayLocal)
        .apply {
            time = this@addMonths
            add(MONTH, months)
        }
        .time
}

fun Calendar.addDays(days: Int): Calendar {
    return copy().apply { add(DAY_OF_YEAR, days) }
}

fun Calendar.getDayOfMonth() : Int {
    return get(Calendar.DAY_OF_MONTH)
}

fun Calendar.getMonthOfYear() : Int {
    return get(MONTH)
}

fun Calendar.getYear() : Int {
    return get(YEAR)
}

fun Date.isOnTheSameDayAs(date: Date): Boolean {
    return (this.toCalendar().clearTime().timeInMillis == date.toCalendar()
        .clearTime().timeInMillis)
}

/**
 * Remove hours, minutes, seconds and milliseconds
 */
fun Calendar.clearTime(): Calendar {
    return this.copy()
        .apply {
            set(HOUR_OF_DAY, 0)
            set(MINUTE, 0)
            set(SECOND, 0)
            set(MILLISECOND, 0)
        }
}