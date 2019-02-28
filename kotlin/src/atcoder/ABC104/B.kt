package atcoder.ABC104

fun main(args: Array<String>) {
    val s = readLine()!!

    val regex = """^A[a-z]+C[a-z]+$""".toRegex()
    if (regex.matches(s)) {
        println("AC")
    } else {
        println("WA")
    }
}