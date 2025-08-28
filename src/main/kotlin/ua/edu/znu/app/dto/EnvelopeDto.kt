package ua.edu.znu.app.dto

data class EnvelopeDto(
    val firstName: String,
    val secondName: String,
    val lastName: String,
    val course: String,
    val faculty: String,
    val phoneNumber: String,
    val addressRegion: String,
    val addressDistrict: String,
    val addressCity: String,
    val addressStreetType: String,
    val addressStreet: String,
    val addressHouse: String,
    val addressApartment: String,
    val profilePictureUrl: String?,
) {
    fun toMap() = mapOf(
        "firstName" to firstName,
        "secondName" to secondName,
        "lastName" to lastName,
        "course" to course,
        "faculty" to faculty,
        "phoneNumber" to phoneNumber,
        "addressRegion" to addressRegion,
        "addressDistrict" to addressDistrict,
        "addressCity" to addressCity,
        "addressStreetType" to addressStreetType,
        "addressStreet" to addressStreet,
        "addressHouse" to addressHouse,
        "addressApartment" to addressApartment,
        "profilePictureUrl" to profilePictureUrl,
    )
}
