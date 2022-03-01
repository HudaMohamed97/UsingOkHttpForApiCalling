package com.example.assignment.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Statistics(
    @SerializedName("popularity") var popularity: Double? = null,
    @SerializedName("estimatedRecentCount") var estimatedRecentCount: Int? = null,
    @SerializedName("estimatedTotalCount") var estimatedTotalCount: Int? = null
): Serializable