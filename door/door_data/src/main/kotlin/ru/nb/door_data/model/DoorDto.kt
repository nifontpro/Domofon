package ru.nb.door_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DoorDto(
	@SerialName("id")
	val id: Int,

	@SerialName("name")
	val name: String,

	@SerialName("favorites")
	val favorites: Boolean,

	@SerialName("room")
	val room: String? = null,

	@SerialName("snapshot")
	val snapshot: String? = null
)