package ua.edu.znu.app.controllers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.edu.znu.app.dto.SettlementReportDto
import ua.edu.znu.app.request_payloads.SettlementReportPayload
import ua.edu.znu.app.services.ReportsGeneratorService
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ReportsController(private val reportsGeneratorService: ReportsGeneratorService) {
    suspend fun getSettlementReport(requestPayload: SettlementReportPayload): ByteArray {
        val applicationData = requestPayload.data.metadata
        val settlementDate = requestPayload.data.settlementDate

        val settlementReportDto = SettlementReportDto(
            firstName = applicationData.firstName ?: "",
            secondName = applicationData.secondName ?: "",
            lastName = applicationData.lastName ?: "",
            faculty = applicationData.faculty ?: "",
            course = applicationData.course ?: "",
            educationLevel = applicationData.educationLevel ?: "",
            dormitory = applicationData.selectedDormitory?.split(" ")?.get(1) ?: "", // take only number
            room = applicationData.selectedRoom ?: "",
            fluorographyLastDate = formatDate(applicationData.fluorographyLastDate ?: ""),
            settlementDate = formatDate(settlementDate)
        )

        return withContext(Dispatchers.IO) {
            reportsGeneratorService.generateSettlementReport(settlementReportDto)
        }
    }

    private fun formatDate(input: String): String {
        if (input == "") {
            return ""
        }

        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val date = LocalDate.parse(input, inputFormatter)

        return date.format(outputFormatter)
    }
}
