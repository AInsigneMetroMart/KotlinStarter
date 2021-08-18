package io.ainsigne.utilities.date

import java.util.*

enum class TimezoneFormat(private val _timeZone: () -> TimeZone) {
    /**
     * UTC timezone is often required when parsing ISO dates
     */
    UTC({ TimeZone.getTimeZone("UTC") }),

    /**
     * Device timezone
     */
    DEVICE({ TimeZone.getDefault() });

    val timeZone: TimeZone
        get() = _timeZone()
}