package io.ainsigne.utilities.date

import java.text.SimpleDateFormat
import java.util.*

class SingleDateFormatterProvider : DateFormatterProvider {
    /**
     * Represents a pool of dateFormatter
     */
    private val poolDateFormatter = hashMapOf<String, SimpleDateFormat>()

    /**
     * Create an unique key for the provided parameters
     */
    private fun createKey(
        dateFormat: DateFormat,
        locale: Locale,
        timeZone: TimezoneFormat
    ): String {
        return dateFormat.pattern + locale.displayCountry + locale.displayLanguage + timeZone.timeZone.id
    }

    override fun get(
        dateFormat: DateFormat,
        locale: Locale,
        timeZone: TimezoneFormat
    ): SimpleDateFormat {
        val key = createKey(dateFormat, locale, timeZone)
        val existingDateFormat = poolDateFormatter[key]
        return if (existingDateFormat == null) {
            val newDateFormatter = SimpleDateFormat(dateFormat.pattern, locale).apply {
                this.timeZone = timeZone.timeZone
            }
            synchronized(poolDateFormatter) { poolDateFormatter[key] = newDateFormatter }
            newDateFormatter
        } else existingDateFormat
    }
}