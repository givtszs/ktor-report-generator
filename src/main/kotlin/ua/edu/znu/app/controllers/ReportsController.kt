package ua.edu.znu.app.controllers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.edu.znu.app.request_payloads.EnvelopeAndTemporaryPassPayload
import ua.edu.znu.app.request_payloads.EnvelopePayload
import ua.edu.znu.app.request_payloads.SettlementAgreementReportPayload
import ua.edu.znu.app.request_payloads.SettlementReportPayload
import ua.edu.znu.app.request_payloads.StudentCardPayload
import ua.edu.znu.app.request_payloads.TemporaryPassPayload
import ua.edu.znu.app.services.ReportsGeneratorService

class ReportsController(private val reportsGeneratorService: ReportsGeneratorService) {
    suspend fun getSettlementReport(requestPayload: SettlementReportPayload): ByteArray =
        withContext(Dispatchers.IO) {
            reportsGeneratorService.generateSettlementReport(requestPayload.data.metadata)
        }

    suspend fun getSettlementAgreementReport(requestPayload: SettlementAgreementReportPayload): ByteArray =
        withContext(Dispatchers.IO) {
            reportsGeneratorService.generateSettlementAgreementReport(requestPayload.data.metadata)
        }

    suspend fun getEnvelope(requestPayload: EnvelopePayload): ByteArray =
        withContext(Dispatchers.IO) {
            reportsGeneratorService.generateEnvelope(requestPayload.data.metadata)
        }

    suspend fun getTemporaryPass(requestPayload: TemporaryPassPayload): ByteArray =
        withContext(Dispatchers.IO) {
            reportsGeneratorService.generateTemporaryPass(requestPayload.data.metadata)
        }

    suspend fun getEnvelopeAndTemporaryPass(requestPayload: EnvelopeAndTemporaryPassPayload): ByteArray =
        withContext(Dispatchers.IO) {
            reportsGeneratorService.generateEnvelopeAndTemporaryPass(requestPayload.data.metadata)
        }

    suspend fun getStudentCard(requestPayload: StudentCardPayload): ByteArray =
        withContext(Dispatchers.IO) {
            reportsGeneratorService.generateStudentCard(requestPayload.data.metadata)
        }
}
