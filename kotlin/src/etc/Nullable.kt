package etc

fun main(args: Array<String>) {


    // 普通のString型はnullを入れられない
    var a: String = "abc"
//    a = null            // !!コンパイルエラー
//    val l = a.length    // OK. aは絶対にnullではないのでヌルポは起こらない


    // NullableなString?型ならnullを入れられる
    var b: String? = "abc"
//    b = null              // String?型にはnullを代入できる
//    val l = b.length      // 変数bはnullがありうるのでコンパイルエラー


    // Nullableな変数のプロパティやメソッドを呼び出すにはnullチェックする
    // チェックと呼び出しの間で変数の参照先が変化しないと保証されているなら、
    // Nullableでない型に勝手にキャストしてくれる
    val l = if (b != null) b.length else -1

    // if文の条件式の中でも、&&や||の前のチェックでnullでないとわかっていれば後ろではキャストされる
    if (b != null && b.length > 0)              // if文のなかでもb.lengthが呼び出せる(b!=nullを確かめているので)
        print("String of length ${b.length}")   // もちろんここでも呼び出せる


    // こんな風にも書ける
    val len = b?.length     // ?を使うと「nullでなければ実行、それでなければnullを返す」
    // lenはnullがありうるので型はInt?と推論される
    // これを使うとこんな風にチェインして書ける
    val longLen = b?.length?.toLong()

    // if (b != null) b.length else -1は、エルビス演算子?:をつかってこのように書ける
    // ?:の前がnullじゃなかったらそっちを、nullだったら後ろを返す
    val blen = b?.length ?: -1




// Nullableに入れるとプリミティブ型として扱われていたものはBoxingされる

    val i = 1000        // JVMのプリミティブ型(int)として格納される
    val j = 1000        // JVMのプリミティブ型(int)として格納される
    // ===演算子は参照先が同じかどうかチェックする
    print(i === j)      // => true


    val boxedI: Int? = 1000     // boxingされる
    val boxedJ: Int? = 1000     // boxingされる
    print(boxedI === boxedJ)    // => false(この２つは別のものを参照している)




}