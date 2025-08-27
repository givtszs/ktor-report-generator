package ua.edu.znu.app.request_payloads

import ua.edu.znu.app.dto.EnvelopeDto

data class EnvelopePayload(
    val data: MetadataPayload<EnvelopeDto>,
)
