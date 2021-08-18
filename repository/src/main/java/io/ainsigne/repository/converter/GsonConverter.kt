package io.ainsigne.repository.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import io.ainsigne.repository.fmcg.model.Fmcg
import java.util.*

class GsonConverter {

    @TypeConverter
    fun fromFmcgs(value: Fmcg?): String {
        return value.toString()
    }

    @TypeConverter
    fun toFmcg(value: String): Fmcg? {
        return Gson().fromJson(value, Fmcg::class.java)
    }

    @TypeConverter
    fun fromFmcgs(value: List<Fmcg>?) = Gson().toJson(value)

    @TypeConverter
    fun toFmcgs(value: String) = Gson().fromJson(value, Array<Fmcg>::class.java).toList()

    @TypeConverter
    fun fromStrings(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun toStrings(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}