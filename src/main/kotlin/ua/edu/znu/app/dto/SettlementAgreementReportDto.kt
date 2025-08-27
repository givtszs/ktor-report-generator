package ua.edu.znu.app.dto

import kotlinx.serialization.Serializable

@Serializable
data class SettlementAgreementReportDto(
    val firstName: String,
    val secondName: String,
    val lastName: String,
    val dormitoryNumber: String,
    val dormitoryAddress: String,
    val roomNumber: String,
    val passportSeries: String,
    val passportNumber: String,
    val passportUnzdr: String,
    val passportIssuer: String,
    val passportIssueDate: String,
    val passportExpiryDate: String,
    val addressRegion: String,
    val addressDistrict: String,
    val addressSettlementType: String,
    val addressCity: String,
    val addressStreetType: String,
    val addressStreet: String,
    val addressHouse: String,
    val addressApartment: String,
) {
    fun toMap() = mapOf(
        "tenantFullName" to "${this.secondName} ${this.firstName} ${this.lastName}",
        "dormitoryNumber" to this.dormitoryNumber,
        "dormitoryAddress" to this.dormitoryAddress,
        "roomNumber" to this.roomNumber,
        "passportSeries" to this.passportSeries,
        "passportNumber" to this.passportNumber,
        "passportUnzdr" to this.passportUnzdr,
        "passportIssuer" to this.passportIssuer,
        "passportIssueDate" to this.passportIssueDate,
        "passportExpiryDate" to this.passportExpiryDate,
        "addressRegion" to this.addressRegion,
        "addressDistrict" to this.addressDistrict,
        "addressSettlementType" to this.addressSettlementType,
        "addressCity" to this.addressCity,
        "addressStreetType" to this.addressStreetType,
        "addressStreet" to this.addressStreet,
        "addressHouse" to this.addressHouse,
        "addressApartment" to this.addressApartment,
    )
}
