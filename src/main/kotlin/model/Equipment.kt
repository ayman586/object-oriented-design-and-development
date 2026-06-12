package model

data class Equipment(
    val equipmentId: String,
    val name: String,
    val category: String,
    var isAvailable: Boolean = true
)