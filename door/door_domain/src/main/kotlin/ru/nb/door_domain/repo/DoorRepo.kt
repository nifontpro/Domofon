package ru.nb.door_domain.repo

import ru.md.base_domain.model.BaseResponse
import ru.nb.door_domain.model.Door

interface DoorRepo {
	suspend fun getAll(): BaseResponse<List<Door>>
}