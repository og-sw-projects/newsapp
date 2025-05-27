package com.example.newsapp.util

import java.time.format.DateTimeFormatter
import java.time.ZoneId
import java.time.Instant

fun formatDate(isoString: String?): String {
    return try {
        val instant = Instant.parse(isoString)
        val zoned = instant.atZone(ZoneId.systemDefault())
        val formatter = DateTimeFormatter.ofPattern("MMM d, yyyy - HH:mm")
        formatter.format(zoned)
    } catch (e: Exception) {
        "Unknown Date"
    }
}