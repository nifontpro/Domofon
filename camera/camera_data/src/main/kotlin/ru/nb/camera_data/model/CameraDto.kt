package ru.nb.camera_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CameraDto(
	@SerialName("id")
	val id: Int,

	@SerialName("name")
	val name: String,

	@SerialName("favorites")
	val favorites: Boolean,

	@SerialName("rec")
	val rec: Boolean,

	@SerialName("room")
	val room: String?,

	@SerialName("snapshot")
	val snapshot: String?
)