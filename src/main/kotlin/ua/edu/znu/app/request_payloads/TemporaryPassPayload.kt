package ua.edu.znu.app.request_payloads

import ua.edu.znu.app.dto.TemporaryPassDto

data class TemporaryPassPayload(
    val data: MetadataPayload<TemporaryPassDto>,
)
