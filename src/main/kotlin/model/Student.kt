package model

data class Student(
    val username: String,
    val reminders: MutableList<Reminder> = mutableListOf(),
    val borrowRequests: MutableList<BorrowRequest> = mutableListOf()
) {

    fun addBorrowRequest(request: BorrowRequest): Boolean {
        if (!request.equipment.isAvailable) {
            return false
        }

        request.equipment.isAvailable = false
        borrowRequests.add(request)
        return true
    }

    fun addReminder(reminder: Reminder) {
        reminders.add(reminder)
    }
}