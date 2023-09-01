package ru.nb.camera_data.repo

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import ru.nb.camera_data.model.db.CameraCol
import ru.nb.camera_data.model.db.toCamera
import ru.nb.camera_data.model.db.toCameraCol
import ru.nb.camera_domain.model.Camera

class DbRepo(
	private val realm: Realm
) {

	suspend fun replaceAll(cameras: List<Camera>) {
		realm.write {
			val olds = this.query<CameraCol>().find()
			delete(olds)
			cameras.forEach { camera ->
				copyToRealm(camera.toCameraCol())
			}
		}
	}

	fun getAll(): List<Camera> {
		return realm.query<CameraCol>().find().map { it.toCamera() }
	}

}