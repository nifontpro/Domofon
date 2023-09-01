package ru.nb.camera_domain.repo

import kotlinx.coroutines.flow.Flow
import ru.md.base_domain.model.BaseResponse
import ru.nb.camera_domain.model.CameraAndRoom

interface CameraRepo {
	fun getAllFlow(): Flow<BaseResponse<CameraAndRoom>>
}