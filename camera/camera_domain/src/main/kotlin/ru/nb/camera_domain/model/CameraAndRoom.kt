package ru.nb.camera_domain.model


data class CameraAndRoom(
	val cameras: List<Camera>,
	val room: List<String>
)