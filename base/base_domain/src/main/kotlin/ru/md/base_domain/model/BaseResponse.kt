package ru.md.base_domain.model

data class BaseResponse<T>(
	val `data`: T? = null,
	val success: Boolean
)