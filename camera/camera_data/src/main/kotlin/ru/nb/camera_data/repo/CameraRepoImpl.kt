package ru.nb.camera_data.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.md.base_domain.model.BaseResponse
import ru.nb.camera_domain.model.CameraAndRoom
import ru.nb.camera_domain.repo.CameraRepo

class CameraRepoImpl(
	private val restRepo: RestRepo,
	private val dbRepo: DbRepo
) : CameraRepo {

	override fun getAllFlow(): Flow<BaseResponse<CameraAndRoom>> = flow {

		val camerasDb = dbRepo.getAll()
		emit(
			BaseResponse(
				data = CameraAndRoom(
					cameras = camerasDb,
					room = emptyList()
				),
				success = true
			)
		)

		val camerasRest = restRepo.getAll()
		if (camerasRest.success) {
			emit(camerasRest)
			camerasRest.data?.let { dbRepo.replaceAll(it.cameras) }
		} else if (camerasDb.isEmpty()) {
			emit(BaseResponse(success = false))
		}

	}.flowOn(Dispatchers.IO)

}