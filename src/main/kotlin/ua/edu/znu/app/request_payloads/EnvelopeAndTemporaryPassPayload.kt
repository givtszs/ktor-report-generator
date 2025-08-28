package ua.edu.znu.app.request_payloads

import ua.edu.znu.app.dto.EnvelopeAndTemporaryPassDto

data class EnvelopeAndTemporaryPassPayload(
    val data: MetadataPayload<EnvelopeAndTemporaryPassDto>,
)
