package ru.nb.camera_presenter.test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.nb.camera_domain.repo.CameraRepo
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
	cameraRepo: CameraRepo
) : ViewModel() {

	var state by mutableStateOf(CameraState()) // Современный аналог liveData
		private set

	private val camerasFlow = cameraRepo.getAllFlow()

	init {
		viewModelScope.launch {
			camerasFlow.collectLatest { result ->
				state = state.copy(
					cameras = result.data?.cameras ?: emptyList(),
					success = result.success,
				)
			}
		}
	}

}