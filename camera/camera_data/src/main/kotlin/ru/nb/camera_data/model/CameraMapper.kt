package ru.nb.camera_data.model

import ru.nb.camera_domain.model.Camera

fun CameraDto.toCamera() = Camera(
	id = id,
	name = name,
	favorites = favorites,
	rec = rec,
	room = room,
	snapshot = snapshot
)