package model

class SystemManager {

    private val equipmentList = mutableListOf(
        Equipment("E1", "Dell Laptop", "Laptop", true),
        Equipment("E2", "HP Laptop", "Laptop", true),
        Equipment("E3", "iPad Tablet", "Tablet", true),
        Equipment("E4", "Samsung Tablet", "Tablet", true),
        Equipment("E5", "Blue Yeti Mic", "Microphone", true),
        Equipment("E6", "Rode Mic", "Microphone", true),
        Equipment("E7", "Canon Camera", "Video Recording Equipment", true)
    )

    fun searchByCategory(category: String): List<Equipment> {

        val results = mutableListOf<Equipment>()

        for (item in equipmentList) {
            if (item.category.equals(category, ignoreCase = true)) {
                results.add(item)
            }
        }

        return results
    }

    fun findEquipmentById(id: String): Equipment? {
        for (item in equipmentList) {
            if (item.equipmentId.equals(id, ignoreCase = true)) {
                return item
            }
        }
        return null
    }
}