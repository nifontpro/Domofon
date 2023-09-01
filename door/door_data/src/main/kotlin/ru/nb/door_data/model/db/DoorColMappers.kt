package ru.nb.door_data.model.db

import ru.nb.door_domain.model.Door

fun DoorCol.toDoor() = Door(
	/*	id = try {
			_id.toString().toInt()
		} catch (e: Exception) {
			-1
		},*/
	id = id,
	name = name,
	favorites = favorites,
	room = room,
	snapshot = snapshot
)

fun Door.toDoorCol(): DoorCol {
	val doorCool = DoorCol()
//	doorCool._id = BsonObjectId.invoke(id.toString())
	doorCool.id = id
	doorCool.name = name
	doorCool.favorites = favorites
	doorCool.room = room
	doorCool.snapshot = snapshot
	return doorCool
}