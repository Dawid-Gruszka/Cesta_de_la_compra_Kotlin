class Compra {
    private val items = arrayListOf<Pair<String, Double>>()

    fun addItem(item: String, price: Double) {
        items.add(Pair(item, price))
    }

    fun removeItem(item: String, cant: Int) {
        val itemToRemove = items.filter { it.first == item }.take(cant)
        items.removeAll(itemToRemove.toSet())
    }

    fun getItems(): List<Pair<String, Double>> {
        return items
    }

    fun getTotalPrice(): Double {
        return items.sumOf { it.second }
    }
}