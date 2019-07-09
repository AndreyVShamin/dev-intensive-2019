package ru.skillbranch.devintensive.utils

object utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
            val parts : List<String>? = fullName?.split(" ")
            var firstName = parts?.getOrNull(index=0)
            var lastName = parts?.getOrNull(index=1)
        //return Pair(firstName, lastName)
            if (firstName == "") firstName = null
            if (lastName == "") lastName = null
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " ") : String{
        //Stub function
        return "Preved Medved"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        // Stub function
        return "PM"
    }
}
