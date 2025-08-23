package ua.edu.znu.app.dto

import kotlinx.serialization.Serializable

@Serializable
data class SettlementReportDto(
    val firstName: String,
    val secondName: String,
    val lastName: String,
    val faculty: String,
    val educationLevel: String,
    val course: String,
    val dormitory: String,
    val room: String,
    val fluorographyLastDate: String,
    val settlementDate: String,
)
