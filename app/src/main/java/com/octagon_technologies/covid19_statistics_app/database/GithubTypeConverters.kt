package com.octagon_technologies.covid19_statistics_app.database

import androidx.annotation.Keep
import androidx.room.TypeConverter
import com.octagon_technologies.covid19_statistics_app.network.allCountries.Global
import com.octagon_technologies.covid19_statistics_app.network.currentCountry.CurrentCountry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@Keep
class GithubTypeConverters {
    private var moshi: Moshi = Moshi.Builder().build()

    @Keep
    @TypeConverter
    fun stringToGlobal(data: String?): Global? {
        val jsonAdapter = moshi.adapter(Global::class.java)

        return jsonAdapter.fromJson(data ?: return null)
    }

    @Keep
    @TypeConverter
    fun globalToString(global: Global?): String {
        val jsonAdapter = moshi.adapter(Global::class.java)
        return jsonAdapter.toJson(global)
    }

    @Keep
    @TypeConverter
    fun stringToCurrentCountry(data: String?): List<CurrentCountry>? {
        val listType = Types.newParameterizedType(List::class.java, CurrentCountry::class.java)
        val jsonAdapter: JsonAdapter<List<CurrentCountry>> = moshi.adapter(listType)

        return jsonAdapter.fromJson(data ?: return null)
    }

    @Keep
    @TypeConverter
    fun currentCountryToString(currentCountry: List<CurrentCountry>): String {
        val listType = Types.newParameterizedType(List::class.java, CurrentCountry::class.java)
        val jsonAdapter: JsonAdapter<List<CurrentCountry>> = moshi.adapter(listType)
        return jsonAdapter.toJson(currentCountry)
    }
}
