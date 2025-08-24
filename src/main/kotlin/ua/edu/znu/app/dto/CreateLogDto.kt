package ua.edu.znu.app.dto

data class CreateLogDto(
    val endpoint: String? = null,
    val method: String? = null,
    val log: String? = null,
    val status: Int? = null,
)
