package com.octagon_technologies.covid19_statistics_app.network.reverse_geocoding_location


import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Keep
data class ReverseGeoCodingLocation(
    @Json(name = "address")
    val reverseGeoCodingAddress: ReverseGeoCodingAddress?,
    @Json(name = "boundingbox")
    val boundingbox: List<String>?,
    @Json(name = "display_name")
    val displayName: String?,
    @Json(name = "lat")
    val lat: String?,
    @Json(name = "licence")
    val licence: String?,
    @Json(name = "lon")
    val lon: String?,
    @Json(name = "osm_id")
    val osmId: String?,
    @Json(name = "osm_type")
    val osmType: String?,
    @Json(name = "place_id")
    val placeId: String?
)