class Compra {
    private val items = arrayListOf<Triple<String, Double, Int>>()

    fun addItem(item: String, price: Double,cant: Int) {
        items.add(Triple(item, price,cant))
    }
/*
    fun removeItem(item: String, cant: Int) {
        val itemToRemove = items.filter { it.first == item }.take(cant)
        items.removeAll(itemToRemove.toSet())
    }
*/
    fun removeItem(item: String, cant: Int) {
        val index = items.indexOfFirst { it.first == item }
        if (index >= 0) {
            val (itemName, price, currentCant) = items[index]
            if (cant >= currentCant) {
                items.removeAt(index)
            } else {
                items[index] = Triple(itemName, price, currentCant - cant)
        }
    } }
    fun getItems(): List<Triple<String, Double, Int>> {
        return items
    }

    fun getTotalPrice(): Double {
        return items.sumOf { it.second }
    }
}