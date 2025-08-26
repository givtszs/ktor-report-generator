package ua.edu.znu.app.request_payloads

import ua.edu.znu.app.dto.SettlementAgreementReportDto

data class SettlementAgreementReportPayload(
    val data: MetadataPayload<SettlementAgreementReportDto>,
)
