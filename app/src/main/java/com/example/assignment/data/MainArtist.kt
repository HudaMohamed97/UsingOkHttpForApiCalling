package com.example.assignment.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MainArtist(
  @SerializedName("id") var id: Int? = null,
  @SerializedName("name") var name: String? = null,
  @SerializedName("role") var role: String? = null
): Serializable