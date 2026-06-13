package model

data class BorrowRequest(
    val requestId: String,
    val student: Student,
    val equipment: Equipment,
    val dueDate: String,
    var status: String
)