package ru.md.base_domain.model

data class BaseResponse<T>(
	val `data`: T,
	val success: Boolean
)