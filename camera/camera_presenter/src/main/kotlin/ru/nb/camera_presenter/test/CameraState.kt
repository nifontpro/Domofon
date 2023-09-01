package ru.nb.camera_presenter.test

import ru.nb.camera_domain.model.Camera

data class CameraState(
	val cameras: List<Camera> = emptyList(),
	val success: Boolean = true,
	val isLoading: Boolean = false,
)
