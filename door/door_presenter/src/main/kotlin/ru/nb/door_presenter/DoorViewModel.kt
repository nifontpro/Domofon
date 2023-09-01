package ru.nb.door_presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.nb.door_domain.repo.DoorRepo
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(
	private val doorRepo: DoorRepo
) : ViewModel() {

	var state by mutableStateOf(DoorState())
		private set

	init {
		viewModelScope.launch {
			state = state.copy(isLoading = true)
			val result = doorRepo.getAll()
			state = state.copy(
				doors = result.data ?: emptyList(),
				success = result.success,
				isLoading = false
			)
		}

	}

}