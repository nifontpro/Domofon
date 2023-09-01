package ru.nb.door_data.db.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class DoorCol : RealmObject {
	@PrimaryKey
	var _id: ObjectId = ObjectId.invoke()

	var name: String = "test"
	var favorites: Boolean = false
	var room: String? = null
	var snapshot: String? = null
}

//class DoorCol(
//	@PrimaryKey
//	var id: ObjectId = ObjectId.invoke(),
//
//	var name: String,
//	var favorites: Boolean,
//	var room: String? = null,
//	var snapshot: String? = null
//) : RealmObject