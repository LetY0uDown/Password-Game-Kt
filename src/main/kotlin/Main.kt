import kotlin.math.abs
import kotlin.random.Random

const val MAX = 1000
const val MIN = 100

fun main() {
    // region Starting
    Color.set(Color.Cyan)

    printlnMultiply("- ", 25)
    println("\tДобро пожаловать в игру The Password Game!")
    printlnMultiply("- ", 25)

    Color.reset()

    println("\nЕё правила просты:")
    println("Вам необходимо угадать пароль, состоящий из случайного трёхзначного числа.")
    println("Игра будет сообщать, если введённое вами число больше или меньше чем данный пароль")

    Color.set(Color.BrightYellow)

    printlnMultiply("- ", 25)

    val gameMode = selectGameMode()
    // endregion

    Color.set(Color.BrightGreen)

    printMultiply("- ", 50)

    Color.reset()

    var attemptsLeft = gameMode.attempts
    var attemptsSpent = 0
    var closestAttempt = MAX

    val password = Random.nextInt(MIN, MAX)

    while (attemptsLeft > 0) {
        print("\nВведите пароль >> ")

        val input = readln().toIntOrNull()

        if ((input == null) or (input !in MIN until MAX)) {
            Color.set(Color.Red)

            println("\nЭто не трёхзначное число! Вы потратили попытку зря D:")

            attemptsSpent++
            attemptsLeft--

            println("Попыток осталось: $attemptsLeft")

            Color.reset()

            continue
        }

        if (abs(password - input!!) < abs(password - closestAttempt)) {
            closestAttempt = input
        }

        when {
            input == password -> {
                println()

                Color.set(Color.BrightGreen)

                printlnMultiply("- ", 50)

                println()

                println("\nПоздравляю! Вы смогли угадать пароль")
                println("Всего потрачено попыток: ${++attemptsSpent}")
                println("Осталось попыток: ${--attemptsLeft}")

                return
            }
            input < password ->
                println("Неверно! Пароль больше, чем это число")
            else ->
                println("Неверно! Пароль меньше, чем это число")
        }

        println("Попыток осталось: ${--attemptsLeft}\nВсего потрачено: ${++attemptsSpent}")
    }

    Color.set(Color.BrightRed)

    println("\nСожалею, но вам не удалось угадать пароль. Вы проиграли!")
    println("Паролем было число $password")
    println("Ближайшая попытка: $closestAttempt")
}

fun selectGameMode() : GameMode {
    println("Список игровых режимов:\n")

    for (i in GameMode.values()) {
        println("${i.ordinal + 1}. ${i.title} - попыток: ${i.attempts}")
    }

    printlnMultiply("- ", 25)

    Color.reset()
    println()

    print("Введите номер режима >> ")
    var mode: Int = -1

    try {
        mode = readln().toInt()
    } catch (e :Exception) {
        println("Вы сделали что-то не так!")
    }

    if (mode !in 1..GameMode.values().size) {
        println("Номер введён неправильно. Попробуйте заного")
    }

    println()

    val gameMode = GameMode.fromInt(mode - 1)

    Color.println("Вы выбрали режим ${gameMode.title}. Удачи в игре!", Color.Blue)

    return gameMode
}

fun printMultiply(str: String, count: Int) {
    for (i in 0 until count) {
        print(str)
    }
}

fun printlnMultiply(str: String, count: Int) {
    println()

    for (i in 0 until count) {
        print(str)
    }

    println()
    println()
}