package ru.nb.camera_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CameraAndRoomDto(
    @SerialName("cameras")
    val cameras: List<CameraDto>,

    @SerialName("room")
    val room: List<String>
)