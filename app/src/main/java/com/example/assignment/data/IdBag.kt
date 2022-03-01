package com.example.assignment.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class IdBag(
    @SerializedName("roviTrackId") var roviTrackId: String? = null
): Serializable