package ru.nb.door_data.repo

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nb.door_data.model.db.DoorCol
import ru.nb.door_data.model.db.toDoor
import ru.nb.door_data.model.db.toDoorCol
import ru.nb.door_domain.model.Door

class DbRepo(
	private val realm: Realm
) {

	suspend fun insert(door: Door) {
		realm.write { copyToRealm(door.toDoorCol()) }
	}

	suspend fun replaceAll(doors: List<Door>) {
		realm.write {
			val olds = this.query<DoorCol>().find()
			delete(olds)
			doors.forEach { door ->
				copyToRealm(door.toDoorCol())
			}
		}
	}

	fun getAll(): List<Door> {
		return realm.query<DoorCol>().find().map { it.toDoor() }
	}

	fun getAllFlow(): Flow<List<Door>> {
		return realm.query<DoorCol>().asFlow().map { it.list.map { doorCol -> doorCol.toDoor() } }
	}

}