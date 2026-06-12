package model

data class Student(
    val username: String,
    val reminders: MutableList<Reminder> = mutableListOf(),
    val borrowRequests: MutableList<BorrowRequest> = mutableListOf()
)