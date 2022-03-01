package com.example.assignment.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ExtendedMetaData(
    @SerializedName("releaseYear") var releaseYear: String? = null,
    @SerializedName("languages") var languages: String? = null,
    @SerializedName("gracenoteRythmApiGenreIds") var gracenoteRythmApiGenreIds: String? = null,
    @SerializedName("moods") var moods: ArrayList<String> = arrayListOf(),
    @SerializedName("tempos") var tempos: ArrayList<String> = arrayListOf(),
    @SerializedName("originalSongId") var originalSongId: String? = null,
    @SerializedName("originalTitle") var originalTitle: String? = null,
    @SerializedName("genresHierarchy") var genresHierarchy: ArrayList<String> = arrayListOf()
): Serializable