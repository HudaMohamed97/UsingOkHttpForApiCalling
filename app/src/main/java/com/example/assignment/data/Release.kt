package com.example.assignment.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Release(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null
): Serializable