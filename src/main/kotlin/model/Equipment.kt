package model

class Equipment(
    val equipmentId: String,
    val name: String,
    val category: String,
    var isAvailable: Boolean
) {
    fun displayInfo(): String {
        return "$name ($category) - Available: $isAvailable"
    }
}