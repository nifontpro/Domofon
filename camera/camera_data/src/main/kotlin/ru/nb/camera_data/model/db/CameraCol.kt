package ru.nb.camera_data.model.db

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class CameraCol : RealmObject {
	@PrimaryKey
	var id: Int = 0
	var name: String = ""
	var favorites: Boolean = false
	var rec: Boolean = false
	var room: String? = null
	var snapshot: String? = null

	override fun toString(): String {
		return "{$id: $name}\n"
	}
}