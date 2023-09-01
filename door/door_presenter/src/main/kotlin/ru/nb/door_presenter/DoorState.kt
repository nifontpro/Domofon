package ru.nb.door_presenter

import ru.nb.door_domain.model.Door

data class DoorState(
	val doors: List<Door> = emptyList(),
	val success: Boolean = true,
)
