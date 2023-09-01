package ru.nb.door_data.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.md.base_domain.model.BaseResponse
import ru.nb.door_domain.model.Door
import ru.nb.door_domain.repo.DoorRepo

class DoorRepoImpl(
	private val restRepo: RestRepo,
	private val dbRepo: DbRepo
) : DoorRepo {

	override fun getAllFlow(): Flow<BaseResponse<List<Door>>> = flow {

		val doorsDb = dbRepo.getAll()
		emit(BaseResponse(data = doorsDb, success = true))

		val doorsRest = restRepo.getAll()
		if (doorsRest.success) {
			emit(doorsRest)
			doorsRest.data?.let { dbRepo.replaceAll(it) }
		} else if (doorsDb.isEmpty()) {
			emit(BaseResponse(success = false))
		}

	}.flowOn(Dispatchers.IO)

}