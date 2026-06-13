import model.Equipment
import model.Student
import model.BorrowRequest


fun main() {

    print("Enter your username: ")
    val username = readLine()?:"Guest"
    val student = Student(username)

    println("\nWelcome $username!")
    val equipmentList = mutableListOf(
        Equipment("E1", "Dell Laptop", "Laptop", true),
        Equipment("E2", "HP Laptop", "Laptop", true),
        Equipment("E3", "iPad Tablet", "Tablet", true),
        Equipment("E4", "Samsung Tablet", "Tablet", true),
        Equipment("E5", "Blue Yeti Mic", "Microphone", true),
        Equipment("E6", "Rode Mic", "Microphone", true),
        Equipment("E7", "Canon Camera", "Video Recording Equipment", true)
    )

    while (true) {

        println("\n--- MENU ---")
        println("1. Search equipment by category")
        println("2.Borrow equipement")
        println("3. Exit")
        print("Choose option: ")

        val choice = readLine()

        when (choice) {

            "1" -> {
                print("\nEnter category (Laptop / Tablet / Microphone / Video Recording Equipment): ")
                val category = readLine()
                var found=false

                println("\nMatching equipment:\n")


                for (item in equipmentList) {
                    if (item.category.equals(category, ignoreCase = true)) {
                        println(item.displayInfo())
                        found = true
                    }
                }

                if (!found) {
                    println("No equipment found in this category.")
                }
            }

            "2" -> {

                print("Enter Equipment ID (e.g. E1): ")
                val equipmentId = readLine()

                var selected: Equipment? = null

                for (item in equipmentList) {
                    if (item.equipmentId.equals(equipmentId, ignoreCase = true)) {
                        selected = item
                    }
                }

                if (selected == null) {
                    println("Equipment not found.")
                } else {

                    print("Enter due date (for example 20/06/2026): ")
                    val dueDate = readLine() ?: ""

                    val request = BorrowRequest(
                        "R1",
                        student,
                        selected,
                        dueDate,
                        "Pending"
                    )

                    val success = student.addBorrowRequest(request)

                    if (success) {
                        println("Borrow request registered successfully.")
                    } else {
                        println("This equipment is currently on loan and cannot be borrowed.")
                    }
                }
            }

            "3" -> {
                println("Goodbye!")
                break
            }

            else -> {
                println("Invalid option.")
            }
        }
    }
}








