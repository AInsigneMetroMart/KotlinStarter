package io.ainsigne.utilities.date

import java.text.SimpleDateFormat
import java.util.*

interface DateFormatterProvider {
    fun get(dateFormat: DateFormat, locale: Locale, timeZone: TimezoneFormat): SimpleDateFormat
}