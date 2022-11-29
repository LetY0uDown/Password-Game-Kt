enum class GameMode(val title: String, val attempts: Int) {
    Unlimited ("Неограниченный", Int.MAX_VALUE),
    Easy ("Лёгкий", 15),
    Middle ("Средний", 10),
    Hard ("Сложный", 7),
    Expert ("Эксперт", 4),
    Fortune ("Фортуна", 1);

    companion object {
        fun fromInt(num: Int?) : GameMode {
            if (num == null)
                throw NullPointerException()

            return GameMode.values().first {
                it.ordinal == num
            }
        }
    }
}