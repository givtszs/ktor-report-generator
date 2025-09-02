package ua.edu.znu.app.request_payloads

import ua.edu.znu.app.dto.StudentCardDto

data class StudentCardPayload(
    val data: MetadataPayload<StudentCardDto>,
)
