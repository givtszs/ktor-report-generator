package ua.edu.znu.app.services

import net.sf.jasperreports.engine.JREmptyDataSource
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperReport
import ua.edu.znu.app.dto.SettlementReportDto

class ReportsGeneratorService(private val jasperReportsService: JasperReportsService) {
    private val settlementReport: JasperReport by lazy { jasperReportsService.compileReport("/reports/settlement-report.jrxml") }

    fun generateSettlementReport(
        settlementReportDto: SettlementReportDto,
    ): ByteArray {
        return try {
            val parameters = mapOf(
                "firstName" to settlementReportDto.firstName,
                "secondName" to settlementReportDto.secondName,
                "lastName" to settlementReportDto.lastName,
                "faculty" to settlementReportDto.faculty,
                "course" to settlementReportDto.course,
                "educationLevel" to settlementReportDto.educationLevel,
                "dormitory" to settlementReportDto.dormitory,
                "room" to settlementReportDto.room,
                "fluorographyLastDate" to settlementReportDto.fluorographyLastDate,
                "settlementDate" to settlementReportDto.settlementDate,
            )

            val jasperPrint = JasperFillManager.fillReport(settlementReport, parameters, JREmptyDataSource(1))

            jasperReportsService.exportToPdf(jasperPrint)
        } catch (e: Exception) {
            throw RuntimeException("Error generating report", e)
        }
    }
}
