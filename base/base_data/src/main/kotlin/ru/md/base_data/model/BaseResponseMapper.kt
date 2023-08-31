package ru.md.base_data.model

import ru.md.base_domain.model.BaseResponse

fun <T, R> BaseResponseDto<T>.toBaseResponse(transform: (T) -> R): BaseResponse<R> = BaseResponse(
	success = success,
	data = data?.let { transform(it) },
)