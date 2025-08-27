package ua.edu.znu.app.controllers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.edu.znu.app.request_payloads.EnvelopePayload
import ua.edu.znu.app.request_payloads.SettlementAgreementReportPayload
import ua.edu.znu.app.request_payloads.SettlementReportPayload
import ua.edu.znu.app.services.ReportsGeneratorService

class ReportsController(private val reportsGeneratorService: ReportsGeneratorService) {
    suspend fun getSettlementReport(requestPayload: SettlementReportPayload): ByteArray {
        return withContext(Dispatchers.IO) {
            reportsGeneratorService.generateSettlementReport(requestPayload.data.metadata)
        }
    }

    suspend fun getSettlementAgreementReport(requestPayload: SettlementAgreementReportPayload): ByteArray {
        return withContext(Dispatchers.IO) {
            reportsGeneratorService.generateSettlementAgreementReport(requestPayload.data.metadata)
        }
    }

    suspend fun getEnvelope(requestPayload: EnvelopePayload): ByteArray {
        return withContext(Dispatchers.IO) {
            reportsGeneratorService.generateEnvelope(requestPayload.data.metadata)
        }
    }
}
