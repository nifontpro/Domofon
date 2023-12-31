package ru.nb.camera_data.repo

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.md.base_data.model.BaseResponseDto
import ru.md.base_data.model.toBaseResponse
import ru.md.base_domain.model.BaseResponse
import ru.nb.camera_data.model.CameraAndRoomDto
import ru.nb.camera_data.model.toCameraAndRoom
import ru.nb.camera_domain.model.CameraAndRoom

class RestRepo(
	private val httpClient: HttpClient,
) {

	suspend fun getAll(): BaseResponse<CameraAndRoom> {
		return withContext(Dispatchers.IO) {
			try {
				val res: BaseResponseDto<CameraAndRoomDto> =
					httpClient.get("http://cars.cprogroup.ru/api/rubetek/cameras/") {
					}.body()
				res.toBaseResponse { it.toCameraAndRoom() }
			} catch (e: Exception) {
				Log.e("rest", e.message.toString())
				BaseResponse(success = false)
			}
		}
	}

}