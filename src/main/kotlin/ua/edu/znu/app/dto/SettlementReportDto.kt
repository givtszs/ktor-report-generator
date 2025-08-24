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
    val housingRate: String,
) {
    fun toMap() = mapOf(
        "firstName" to this.firstName,
        "secondName" to this.secondName,
        "lastName" to this.lastName,
        "faculty" to this.faculty,
        "course" to this.course,
        "educationLevel" to this.educationLevel,
        "dormitory" to this.dormitory,
        "room" to this.room,
        "fluorographyLastDate" to this.fluorographyLastDate,
        "settlementDate" to this.settlementDate,
        "housingRate" to this.housingRate
    )
}
