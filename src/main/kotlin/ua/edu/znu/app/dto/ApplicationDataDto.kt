package ua.edu.znu.app.dto

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationDataDto(
    /** draft application data */
    val selectedType: String? = null,
    val selectedUniversity: String? = null,

    /** submitted application data */
    val firstName: String? = null,
    val secondName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val photo: String? = null,

    val passportType: String? = null,
    val passportBirthPlace: String? = null,
    val passportSeries: String? = null,
    val passportNumber: String? = null,
    val passportIssuedBy: String? = null,
    val passportDateIssued: String? = null,
    val passportUnzdr: String? = null,
    val passportValidity: String? = null,
    val dateBirth: String? = null,
    val genderType: String? = null,
    val passportPhoto1: String? = null,
    val passportPhoto2: String? = null,
    val passportPhoto3: String? = null,

    val educationLevel: String? = null,
    val course: String? = null,
    val faculty: String? = null,
    val specialization: String? = null,
    val sourceOfFunding: String? = null,
    val formOfEducation: String? = null,

    val addressRegion: String? = null,
    val addressDistrict: String? = null,
    val addressSettlementType: String? = null,
    val addressCity: String? = null,
    val addressStreetType: String? = null,
    val addressStreet: String? = null,
    val addressHouse: String? = null,
    val addressApartment: String? = null,

    val residenceRegion: String? = null,
    val residenceDistrict: String? = null,
    val residenceSettlementType: String? = null,
    val residenceCity: String? = null,
    val residenceStreetType: String? = null,
    val residenceStreet: String? = null,
    val residenceHouse: String? = null,
    val residenceApartment: String? = null,

    val familyMembersData: String? = null,
    val familyPhoto: String? = null,

    val privilegeExists: String? = null,
    val privilegeType: String? = null,
    val privilegeOtherPrivilege: String? = null,
    val privilegePhoto1: String? = null,
    val privilegePhoto2: String? = null,
    val privilegePhoto3: String? = null,

    val fluorographyLastDate: String? = null,
    val fluorographyPhoto1: String? = null,
    val fluorographyPhoto2: String? = null,
    val medicalVaccinePhoto: String? = null,
    val appealToAdministration: String? = null,

    val selectedDormitory: String? = null,
    val selectedRoom: String? = null,
    val consent: String? = null,
)
