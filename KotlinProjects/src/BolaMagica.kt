//Answers
const val POSITIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//mapping answers
val answers = mapOf(
    "Yes" to POSITIVE_ANSWER,
    "It's true" to POSITIVE_ANSWER,
    "Totally" to POSITIVE_ANSWER,
    "Without a doubt" to POSITIVE_ANSWER,
    "Ask again later" to DOUBTFUL_ANSWER,
    "I can't answer that right now" to DOUBTFUL_ANSWER,
    "Maybe" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Don't count on that" to NEGATIVE_ANSWER,
    "Definitely" to NEGATIVE_ANSWER,
    "I don't think so" to NEGATIVE_ANSWER,
)

fun main(args: Array<String>) {
    var input: String
    do {
        println("""
            
        "Hello, I'm the Kotlin 8 ball. What do you want to do?"
        1. Ask something
        2. Check answers
        3. Exit
    """.trimIndent())
        input = readLine().toString()

        when(input) {
            "1" -> askSomething()
            "2" -> showAnswers()
            "3" -> exit()
            else -> showError()
        }
    } while (input == "1" || input == "2" || input == "3")
}

fun askSomething() {
    println("What is you question?")
    readLine()
    val answer = answers.keys.random()
    println("So... that's your question... The answer is: $answer")
}

fun showAnswers() {
    println("""
        Select one option:
        1. All answers
        2. Positive answers
        3. Negative answers
        4. Doubtful answers
    """.trimIndent())
    val input = readLine()
    when(input) {
        "1" -> answersType(type = "ALL")
        "2" -> answersType(type = POSITIVE_ANSWER)
        "3" -> answersType(type = NEGATIVE_ANSWER)
        "4" -> answersType(type = DOUBTFUL_ANSWER)
        else -> println("Not a valid input. Goodbye.")
    }
}

fun answersType(type: String = "ALL") {
    val printAnswers: (Map<String, String>) -> Unit = {
        it.keys.forEach { answer -> println(answer) }
    }
    when(type) {
        "ALL" -> answers.keys.forEach { answer -> println(answer) }
        POSITIVE_ANSWER -> answers.filterValues { value -> value == POSITIVE_ANSWER }
            .also { printAnswers(it) }
        NEGATIVE_ANSWER -> answers.filterValues { value -> value == NEGATIVE_ANSWER }
            .also { printAnswers(it) }
        DOUBTFUL_ANSWER -> answers.filterValues { value -> value == DOUBTFUL_ANSWER }
            .also { printAnswers(it) }
        else -> println("Error, bye.")
    }
}

fun exit() {
    println("See you later.")
}

fun showError() {
    println("There was an error...")
}