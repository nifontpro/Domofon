package ru.nb.door_presenter

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DoorScreen(
	viewModel: DoorViewModel = hiltViewModel()
) {

	val state = viewModel.state
	DoorView(state = state)

}