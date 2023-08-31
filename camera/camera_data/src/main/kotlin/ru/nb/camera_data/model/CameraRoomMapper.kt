package ru.nb.camera_data.model

import ru.nb.camera_domain.model.CameraAndRoom

fun CameraAndRoomDto.toCameraAndRoom() = CameraAndRoom(
	room = room,
	cameras = cameras.map { it.toCamera() }
)