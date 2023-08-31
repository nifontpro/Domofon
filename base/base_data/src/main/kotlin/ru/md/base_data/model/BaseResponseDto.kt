package ru.md.base_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponseDto<T>(
	@SerialName("data")
	val `data`: T,
	@SerialName("success")
	val success: Boolean
)