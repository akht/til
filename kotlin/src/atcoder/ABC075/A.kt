package atcoder.ABC075

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }

    // XORをとればいい
    // n XOR n = 0で、(同じ数同士のXORは0になる)
    // 0 XOR n = nなので、(0とのXORは必ずもう片方の数になる)
    // ２つの数が同じなら打ち消しあって0になり、残りの仲間はずれだけが残る

    println(a xor b xor c)
}