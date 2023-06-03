package com.skeleton.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDateTime(dateTimeString: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val dateTime = LocalDateTime.parse(dateTimeString, formatter)
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss")
        return dateTime.format(outputFormatter)
    }
}