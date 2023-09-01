package ru.nb.door_data.repo

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.md.base_data.model.BaseResponseDto
import ru.md.base_data.model.toBaseResponse
import ru.md.base_domain.model.BaseResponse
import ru.nb.door_data.model.DoorDto
import ru.nb.door_data.model.toDoor
import ru.nb.door_domain.model.Door
import ru.nb.door_domain.repo.DoorRepo

class DoorRepoImpl(
	private val httpClient: HttpClient,
) : DoorRepo {

	override suspend fun getAll(): BaseResponse<List<Door>> {
		return withContext(Dispatchers.IO) {
			try {
				val res: BaseResponseDto<List<DoorDto>> =
					httpClient.get("http://cars.cprogroup.ru/api/rubetek/doors/") {
					}.body()
				res.toBaseResponse { it.map { doorDto -> doorDto.toDoor() } }
			} catch (e: Exception) {
				Log.e("rest", e.message.toString())
				BaseResponse(success = false)
			}
		}
	}
}