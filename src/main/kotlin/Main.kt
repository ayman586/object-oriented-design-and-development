import model.BorrowRequest
import model.Equipment
import model.Student
import model.Reminder
import java.time.LocalDate
import model.SystemManager

fun main() {

    print("Enter your username: ")
    val username = readLine() ?: "Guest"

    val student = Student(username)

    val systemManager = SystemManager()

    if (username.equals("john", ignoreCase = true)) {

        student.addReminder(
            Reminder(
                "Please return the Dell Laptop by Friday.",
                LocalDate.of(2026, 6, 20)
            )
        )

        student.addReminder(
            Reminder(
                "Your borrowing request has been approved.",
                LocalDate.of(2026, 6, 18)
            )
        )
    }

    if (username.equals("emma", ignoreCase = true)) {

        student.addReminder(
            Reminder(
                "The microphone you requested is ready for collection.",
                LocalDate.of(2026, 6, 18)
            )
        )
    }

    println("\nWelcome $username!")

    if (student.reminders.isNotEmpty()) {

        println("\n--- REMINDERS ---")

        for (reminder in student.reminders) {
            println("${reminder.message} (${reminder.date})")
        }

        println("-----------------\n")
    }

    while (true) {

        println("\n--- MENU ---")
        println("1. Search equipment by category")
        println("2. Borrow equipment")
        println("3. View my borrow requests")
        println("4. Exit")
        print("Choose option: ")

        when (readLine()) {

            "1" -> {
                print("\nEnter category (Laptop / Tablet / Microphone / Video Recording Equipment): ")
                val category = readLine() ?: ""

                val results = systemManager.searchByCategory(category)

                println("\nMatching equipment:\n")

                if (results.isEmpty()) {
                    println("No equipment found in this category.")
                } else {
                    for (item in results) {
                        println(item.displayInfo())
                    }
                }
            }

            "2" -> {

                print("Enter Equipment ID (e.g. E1): ")
                val equipmentId = readLine() ?: ""

                val selected = systemManager.findEquipmentById(equipmentId)

                if (selected == null) {
                    println("Equipment not found.")
                } else {

                    print("Enter due date (e.g. 20/06/2026): ")
                    val dueDate = readLine() ?: ""

                    val request = BorrowRequest(
                        requestId = "R1",
                        student = student,
                        equipment = selected,
                        dueDate = dueDate,
                        status = "PENDING"
                    )

                    val success = student.addBorrowRequest(request)

                    if (success) {
                        println("Borrow request successful.")
                    } else {
                        println("This equipment is currently on loan and cannot be borrowed.")
                    }
                }
            }

            "3" -> {

                if (student.borrowRequests.isEmpty()) {
                    println("You have no equipment requests.")
                } else {
                    println("\nYour equipment requests:\n")

                    for (request in student.borrowRequests) {
                        println(
                            "${request.equipment.name} - Due: ${request.dueDate} - Status: ${request.status}"
                        )
                    }
                }
            }

            "4" -> {
                println("Goodbye!")
                break
            }

            else -> {
                println("Invalid option. Try again.")
            }
        }
    }
}