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
        return withContext(Dispatchers.IO) {
            reportsGeneratorService.generateSettlementReport(requestPayload.data.metadata)
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
