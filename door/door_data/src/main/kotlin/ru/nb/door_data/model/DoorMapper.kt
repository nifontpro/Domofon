package ru.nb.door_data.model

import ru.nb.door_domain.model.Door

fun DoorDto.toDoor() = Door(
	id = id,
	name = name,
	favorites = favorites,
	room = room,
	snapshot = snapshot
)