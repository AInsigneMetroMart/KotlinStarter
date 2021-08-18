package io.ainsigne.repository.room.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverters {

    @TypeConverter
    fun fromValue(value: String?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }

    @TypeConverter
    fun dateToTimestamp(value: BigDecimal?): String? {
        return value?.toPlainString()
    }
}