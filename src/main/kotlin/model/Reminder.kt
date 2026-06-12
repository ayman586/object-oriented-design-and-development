package model

import java.time.LocalDate

data class Reminder(
    val message: String,
    val date: LocalDate
)