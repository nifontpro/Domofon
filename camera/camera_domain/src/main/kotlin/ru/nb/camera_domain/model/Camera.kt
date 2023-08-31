package ru.nb.camera_domain.model


data class Camera(
	val id: Int,
	val name: String,
	val favorites: Boolean,
	val rec: Boolean,
	val room: String?,
	val snapshot: String?
)