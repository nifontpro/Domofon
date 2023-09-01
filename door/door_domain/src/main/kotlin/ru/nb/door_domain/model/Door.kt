package ru.nb.door_domain.model

data class Door(
	val id: Int,
	val name: String,
	val favorites: Boolean,
	val room: String?,
	val snapshot: String?
)