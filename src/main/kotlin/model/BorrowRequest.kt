package model

import java.time.LocalDate

data class BorrowRequest(
    val requestId: String,
    val student: Student,
    val equipment: Equipment,
    val dueDate: LocalDate,
    var status: String
)