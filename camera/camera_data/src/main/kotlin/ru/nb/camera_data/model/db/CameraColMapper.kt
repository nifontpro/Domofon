package ru.nb.camera_data.model.db

import ru.nb.camera_domain.model.Camera

fun CameraCol.toCamera() = Camera(
	id = id,
	name = name,
	favorites = favorites,
	rec = rec,
	room = room,
	snapshot = snapshot
)

fun Camera.toCameraCol(): CameraCol {
	val cameraCool = CameraCol()
	cameraCool.id = id
	cameraCool.name = name
	cameraCool.favorites = favorites
	cameraCool.rec = rec
	cameraCool.room = room
	cameraCool.snapshot = snapshot
	return cameraCool
}