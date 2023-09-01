package ru.nb.door_domain.repo

import kotlinx.coroutines.flow.Flow
import ru.md.base_domain.model.BaseResponse
import ru.nb.door_domain.model.Door

interface DoorRepo {
	fun getAllFlow(): Flow<BaseResponse<List<Door>>>
}