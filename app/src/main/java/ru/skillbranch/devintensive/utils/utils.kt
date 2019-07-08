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
}