package ua.edu.znu.app.services

import net.sf.jasperreports.engine.JREmptyDataSource
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperReport
import ua.edu.znu.app.dto.EnvelopeDto
import ua.edu.znu.app.dto.SettlementAgreementReportDto
import ua.edu.znu.app.dto.SettlementReportDto

class ReportsGeneratorService(private val jasperReportsService: JasperReportsService) {
    private val settlementReport: JasperReport by lazy { jasperReportsService.compileReport("/reports/settlement-report.jrxml") }
    private val settlementAgreementReport: JasperReport by lazy { jasperReportsService.compileReport("/reports/settlement-agreement-report.jrxml") }
    private val envelope: JasperReport by lazy { jasperReportsService.compileReport("/reports/envelope.jrxml") }

    fun generateSettlementReport(
        settlementReportDto: SettlementReportDto,
    ): ByteArray {
        return try {
            val parameters = settlementReportDto.toMap()

            val jasperPrint = JasperFillManager.fillReport(
                settlementReport,
                parameters,
                JREmptyDataSource(1)
            )

            jasperReportsService.exportToPdf(jasperPrint)
        } catch (e: Exception) {
            throw RuntimeException("Error generating report", e)
        }
    }

    fun generateSettlementAgreementReport(
        settlementAgreementReportDto: SettlementAgreementReportDto,
    ): ByteArray {
        return try {
            val parameters = settlementAgreementReportDto.toMap()

            val jasperPrint = JasperFillManager.fillReport(
                settlementAgreementReport,
                parameters,
                JREmptyDataSource(1)
            )

            jasperReportsService.exportToPdf(jasperPrint)
        } catch (e: Exception) {
            throw RuntimeException("Error generating report", e)
        }
    }

    fun generateEnvelope(
        envelopeDto: EnvelopeDto,
    ): ByteArray {
        return try {
            val parameters = envelopeDto.toMap()

            val jasperPrint = JasperFillManager.fillReport(
                envelope,
                parameters,
                JREmptyDataSource(1)
            )

            jasperReportsService.exportToPdf(jasperPrint)
        } catch (e: Exception) {
            throw RuntimeException("Error generating report", e)
        }
    }
}
