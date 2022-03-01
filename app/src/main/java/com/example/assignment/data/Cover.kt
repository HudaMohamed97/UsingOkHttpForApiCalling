package com.example.assignment.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cover(
    @SerializedName("tiny") var tiny: String? = null,
    @SerializedName("small") var small: String? = null,
    @SerializedName("medium") var medium: String? = null,
    @SerializedName("large") var large: String? = null
): Serializable