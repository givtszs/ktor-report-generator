package ua.edu.znu.app.dto

data class TemporaryPassDto(
    val firstName: String,
    val secondName: String,
    val lastName: String,
    val course: String,
    val faculty: String,
    val dormitoryNumber: String,
    val roomNumber: String,
    val profilePictureUrl: String,
) {
    fun toMap() = mapOf(
        "firstName" to firstName,
        "secondName" to secondName,
        "lastName" to lastName,
        "course" to course,
        "faculty" to faculty,
        "dormitoryNumber" to dormitoryNumber,
        "roomNumber" to roomNumber,
        "profilePictureUrl" to profilePictureUrl,
    )
}
