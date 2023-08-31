package ru.nb.camera_presenter.test

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CameraScreen(
	viewModel: CameraViewModel = hiltViewModel()
) {

	val state = viewModel.state
	CameraView(state = state)

}