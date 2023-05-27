package com.skeleton.myapplication

object Utils {
    fun capitalizeFirstLetter(input: String): String {
        if (input.isEmpty()) {
            return input
        }

        val firstChar = input[0]
        val capitalizedFirstChar = firstChar.toUpperCase()
        val restOfString = input.substring(1)

        return capitalizedFirstChar + restOfString
    }

}