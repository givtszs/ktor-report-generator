package ua.edu.znu.app.request_payloads

import ua.edu.znu.app.dto.SettlementReportDto

data class SettlementReportPayload(
    val data: Metadata,
)

data class Metadata(
    val metadata: SettlementReportDto,
)
