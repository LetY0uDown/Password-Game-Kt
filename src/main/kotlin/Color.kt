enum class Color(val code: String) {
    Black ("\u001b[30m"),
    Red ("\u001b[31m"),
    Green ("\u001b[32m"),
    Yellow ("\u001b[33m"),
    Blue ("\u001b[34m"),
    Magenta ("\u001b[35m"),
    Cyan ("\u001b[36m"),
    White ("\u001b[37m"),
    BrightBlack ("\u001b[30;1m"),
    BrightRed ("\u001b[31;1m"),
    BrightGreen ("\u001b[32;1m"),
    BrightYellow ("\u001b[33;1m"),
    BrightBlue ("\u001b[34;1m"),
    BrightMagenta ("\u001b[35;1m"),
    BrightCyan ("\u001b[36;1m"),
    BrightWhite ("\u001b[37;1m");

    companion object {
        fun reset() {
            print("\u001b[0m")
        }

        fun set(color: Color) {
            print(color.code)
        }

        fun println(msg: String, color: Color) {
            set(color)
            println(msg)
            reset()
        }
    }
}

