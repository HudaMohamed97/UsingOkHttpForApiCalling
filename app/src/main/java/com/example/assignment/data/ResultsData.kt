package com.example.assignment.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResultsData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("duration") var duration: Int? = null,
    @SerializedName("publishingDate") var publishingDate: String? = null,
    @SerializedName("mainArtist") var mainArtist: MainArtist? = MainArtist(),
    @SerializedName("volumeNumber") var volumeNumber: Int? = null,
    @SerializedName("trackNumber") var trackNumber: Int? = null,
    @SerializedName("release") var release: Release? = Release(),
    @SerializedName("genres") var genres: ArrayList<String> = arrayListOf(),
    @SerializedName("additionalArtists") var additionalArtists: ArrayList<AdditionalArtists> = arrayListOf(),
    @SerializedName("idBag") var idBag: IdBag? = IdBag(),
    @SerializedName("statistics") var statistics: Statistics? = Statistics(),
    @SerializedName("adfunded") var adfunded: Boolean? = null,
    @SerializedName("streamable") var streamable: Boolean? = null,
    @SerializedName("bundleOnly") var bundleOnly: Boolean? = null,
    @SerializedName("cover") var cover: Cover? = Cover(),
    @SerializedName("extendedMetaData") var extendedMetaData: ExtendedMetaData? = ExtendedMetaData()
):Serializable