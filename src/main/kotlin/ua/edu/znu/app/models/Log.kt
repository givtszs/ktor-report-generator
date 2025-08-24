package ua.edu.znu.app.models

import kotlinx.datetime.LocalDateTime

data class Log(
    val id: Int,
    val endpoint: String? = null,
    val method: String? = null,
    val log: String? = null,
    val status: Int? = null,
    val createdAt: LocalDateTime
)
