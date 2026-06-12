import model.Equipment

fun main() {

    print("Enter your username: ")
    val username = readLine()

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
        println("2. Exit")
        print("Choose option: ")

        val choice = readLine()

        when (choice) {

            "1" -> {
                print("\nEnter category (Laptop / Tablet / Microphone / Video Recording Equipment): ")
                val category = readLine()

                println("\nMatching equipment:\n")

                var found = false

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
                println("Goodbye!")
                break
            }

            else -> {
                println("Invalid option. Try again.")
            }
        }
    }
}