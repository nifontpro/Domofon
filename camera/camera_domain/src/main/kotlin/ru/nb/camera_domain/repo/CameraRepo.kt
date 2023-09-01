package ru.nb.camera_domain.repo

import ru.md.base_domain.model.BaseResponse
import ru.nb.camera_domain.model.CameraAndRoom

interface CameraRepo {
	suspend fun getAll(): BaseResponse<CameraAndRoom>
}