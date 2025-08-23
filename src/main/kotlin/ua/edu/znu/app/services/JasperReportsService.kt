package ua.edu.znu.app.services

import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.JasperReport
import net.sf.jasperreports.engine.export.JRPdfExporter
import net.sf.jasperreports.export.SimpleExporterInput
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput
import net.sf.jasperreports.export.SimplePdfExporterConfiguration
import java.io.ByteArrayOutputStream
import java.io.InputStream

class JasperReportsService {
    fun compileReport(path: String): JasperReport {
        val reportStream: InputStream = this::class.java.getResourceAsStream(path)
            ?: throw IllegalArgumentException("Report template not found: $path")

        return JasperCompileManager.compileReport(reportStream)
    }

    fun exportToPdf(jasperPrint: JasperPrint): ByteArray {
        val outputStream = ByteArrayOutputStream()
        val pdfExporter = JRPdfExporter()

        pdfExporter.setExporterInput(SimpleExporterInput(jasperPrint))
        pdfExporter.setExporterOutput(SimpleOutputStreamExporterOutput(outputStream))
        pdfExporter.setConfiguration(SimplePdfExporterConfiguration())
        pdfExporter.exportReport()

        return outputStream.toByteArray()
    }
}
