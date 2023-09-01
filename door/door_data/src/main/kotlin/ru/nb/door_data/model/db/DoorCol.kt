package ru.nb.door_data.model.db

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class DoorCol : RealmObject {
	@PrimaryKey
//	var _id: ObjectId = ObjectId.invoke()
	var id: Int = 0
	var name: String = ""
	var favorites: Boolean = false
	var room: String? = null
	var snapshot: String? = null

	override fun toString(): String {
		return "{$id: $name}\n"
	}
}