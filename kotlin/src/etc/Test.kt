package etc

import java.lang.Integer.parseInt
import java.lang.reflect.Array.get
import java.util.logging.Logger


// https://qiita.com/k5n/items/cc0377b75d8537ef8a85

fun main(args: Array<String>) {
    println("Hello, World!")


    // valはイミュータブル
    val num = 3

    // varはミュータブル
    var i = 0
    i = 1

    // 明示的に型を指定
    val a: Byte = 1

// ---- 数値定数 ----
    val digits  = 123           // 10進数
    val longInt = 123L          // Long(末尾にLをつければLong型だと推論される)
    val hex     = 0x0F          // 16進数
    val bin     = 0b00001011    // 2進数
    val dbl     = 123.5         // 浮動小数点数はデフォルトでDouble型
    val withE   = 123.5e10      // 123.5 * 10^10
    val flt     = 123.5f        // Floatなら末尾にfかFをつける


// ---- 文字と文字列 ----
    // 1文字のChar型はシングルクォートで囲う
    val c = '0'
    val n = '\n'
    val u = '\uFF00'

    val s = "Hello, world!"
    // トリプル句オートを使うとエスケープが効かない生文字列になる
    val text = """
        改行も含めて書いたとおりの文字列になる。
            もちろんインデントも。
    """

    // $を使って文字列の中に変数の値や計算結果を埋め込める。トリプルクォートでも使える
    // $そのものを表示したいときは ${'$'}と書く
    val i2 = 10
    val str = "i2 = $i2, i2 × 2 = ${i2 * 2}" // "i2 = 10, i2 × 2 = 20"

    // 文字列(String)はimmutableで構成要素は文字(Char)
    val c0 = str[0]
    for (chr in str) {  // forループでイテレートできる
        println(chr)
    }


// ---- 配列 ----
    // 配列はArray<T>クラスで表される

    // [1, 2, 3]を作る
    val list = arrayOf(1, 2, 3)

    // nullで埋められたサイズ3の配列を作る
    var arr: Array<Int?> = arrayOfNulls(3)

    // Array<String>型で値が["0", "1", "4", "9", "16"]の配列を作る
    val asc = Array(5) { (it * it).toString() }

    // for文で回す
    for (item in list) {
        println(item)
    }

    // []で要素にアクセスしたり
    list[0] = list[1] + list[2]     // Arrayはmutable(中身を変更可能)



    // switchの置き換えとしてwhenがある。breakはいらない(パターンマッチとして使える)
    val ii = 1
    when (ii) {
        1 -> print("ii == 1")
        2 -> print("ii == 2")
        else -> { // ブロックもつかえる
            print("x is neither 1 nor 2")
        }
    }



    val validNumbers = listOf(1, 2, 3)

    // switchよりはるかに強力
    when (ii) {
    // 複数の値をコンマで区切って指定できる
        0, 1 -> print("x ==0 or x == 1")

    // 定数でなくてもマッチさせられる
        parseInt(s) -> print("s encodes x")

    // 範囲に含まれるか
        in 2..10 -> print("x is in the range")

    // 配列などのコレクションに含まれるか
        in validNumbers -> print("x is valid")

    // 否定も使える。範囲に含まれなければ実行される
        !in 10..20 -> print("x is outside the range")

        else -> print("one of the above")
    }

    val ss = "abc"

    // whenもifと同様に式であり、値を返せる
    val hasPrefix = when (ss) {
    // 型チェックもできる。チェック後は自動的にキャストされる
        is String -> ss.startsWith("prefix")
        else -> false
    }


    // 引数を与えなければifの代わりに使える
    when {
        ii == 1 -> println("ii == 1")
        ii == 2 -> println("ii == 2")
        else -> println("ii is neither 1 nor 2")
    }



// ---- for ----

    val collection = List(10) {it * it}

    // collection内の各アイテムをitemとしてループ
    for (item in collection) {
        println(item)
    }

    // インデックスつきにしたい場合
    for (i in collection.indices) {
        println(collection[i])
    }

    // withIndex9)でインデックスと値のペアで回すこともできる
    for ((index, value) in collection.withIndex()) {
        println("the element at $index is $value")
    }

    // マップをキーと値のペアで回す
    val map = mutableMapOf(1 to "A", 2 to "B", 3 to "C")
    for ((k, v) in map) {
        println("key=$k, value=$v")
    }


//    while (x) {
//        x--
//    }

//    do {
//
//        val y = hoge()
//
//    } while (y != null)   // ←ここでyが見える


// ---- 範囲 ----
    if (i in 1..10) {
        print(i)
    }

    // 整数型の範囲(IntRange, LongRange, CharRange)はイテレート可能
    for (i in 1..4) print(i)        // => 1234

    // 逆順
    for (i in 4 downTo 1) print(i)  // => 4321

    // ステップ量を変える
    for (i in 1..4 step 2) print(i) // => 13
    for (i in 4 downTo 1 step 2) print(i)   // =>42

}


// 関数はパッケージのトップレベルで宣言できる（クラスメソッドにする必要はない）
fun double(x: Int): Int {
    return x * 2
}

// 関数の中身が式１つだけなら波括弧は省略できる
fun double2(x: Int): Int = x * 2
// 波括弧を省略した場合、戻り値の型が推論可能ならそれも省略できる
fun double3(x: Int) = x * 2

// 引数にはデフォルト値を指定できる（オーバーロードの数を減らせる）
// 戻り値が必要ない場合の型はUnitだが省略可能
fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {

    // 処理...
    // return Unitじゃなく、return でいいし、returnも省略できる
}


fun main2(args: Array<String>) {

    // デフォルト値を使って呼ぶ
    reformat("hoge")

    // デフォルト値を使わないで呼ぶ
    reformat("hoge", true, true, false, '_')

    // 引数名を指定して呼ぶ
    reformat("hoge",
            normalizeCase = true,
            upperCaseFirstLetter = true,
            divideByCamelHumps = false,
            wordSeparator = '_')

    // divideByCamelHumpsだけデフォルト値を使わずに呼ぶ
    reformat("hoge", divideByCamelHumps = true)
}


fun main3(args: Array<String>) {

    // varargを付けると可変長引数になる。引数はArrayとして渡される
    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) {     // tsはArray
            result.add(t)
        }
        return result
    }

    // こんな風に可変個の引数を渡せる
    val list = asList(1, 2, 3)

    // 既に配列として持っているものを渡す場合、*で展開する
    val a = arrayOf(1, 2, 3)
    val list2 = asList(-1, 0, *a, 4)    // *をつけて展開して渡す

}

// 中身がないクラス。コンストラクタを定義しないと、自動で引数無しコンストラクタが生成される
class Empty

// １つのプライマリコンストラクタと複数のセカンダリコンストラクタを持てる
// プライマリコンストラクタの宣言はクラスヘッダに書く
class Customer(name: String) {

    // プライマリコンストラクタの引数がこのなかで使える
    init {
        println("Customer initialized with value $name")
    }

    // プライマリコンストラクタの引数がプロパティの初期化でも使える
    val customerKey = name.toUpperCase()

    // セカンダリコンストラクタ
    constructor(firstName: String, lastName: String) : this("$firstName $lastName") {
        println("firstName = $firstName, lastName = $lastName")
    }
}


// コンストラクタの引数にval, varを指定できる。指定したものは自動でプロパティ化される
class Person(val firstName: String, val lastName: String, var age: Int) {

    // ...

}

fun main4(args: Array<String>) {

    // インスタンス生成にnewキーワードは不要。コンストラクタを関数のように呼び出す
    val person = Person("Joe", "Smith", 30)
    println(person.firstName)   // firstNameはプロパティ化されている
    person.age++;               // ageはvar指定したので変更可

}


class MyClass {
    var initialized = 1 // 型推論によりInt型、でふぉるとのgetter/setter利用

    var size = 100

    // カスタムgetter/setterを定義（この場合、バッキングフィールドは生成されない）
    var stringRepresentation: String
        get() = this.toString()
        set(value) {    // setterの引数は慣習でvalueだが、好みで良い
            //setDataFromString(value)  // 文字列をパースして他のプロパティに代入
        }

    var setterVisibility: String = "abc"
        private set // private指定してsetterはこのクラス内のみ利用可。実装はデフォルトを利用

    //var setterWithAnnotation: Any?  // 初期値指定なし
    //@Inject set   // setterにInjectアノテーションをつける。実装はデフォルトを利用


    // valだと当たり前だがsetterは定義できない
    // val simple: Int?    // Int?型、デフォルトのgetter利用。初期値がないのでコンストラクタで初期化必須

    val inferredType = 1    // Int型、デフォルトのgetter利用

    val isEmpty: Boolean    // バッキングフィールドはない
        get() = this.size == 0  // カスタムgetterを定義


    var counter = 0
        set(value) {
            if (value >= 0)
                field = value
        }
}



// シールドクラス
// Enumに似ているが、状態を持つことが出来、複数のインスタンスを生成できる
sealed class Expr {
    class Const(val number: Double) : Expr()
    class Sum(val e1: Expr, val e2: Expr) : Expr()
    class NotANumber : Expr()
}

// whenと一緒につかうと便利
fun eval(expr: Expr): Double = when(expr) {
    is Expr.Const -> expr.number
    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
    is Expr.NotANumber -> Double.NaN
// 全てのケースをカバーしているのでelseはいらない
// Exprを継承できるのは内部クラスだけなので、上で定義されてる分だけしかないことを
// コンパイラは知っている
}


// ---- 拡張 ----
// 既存クラスやオブジェクトに、関数を追加できる
fun main5(args: Array<String>) {

    // MutableList<Int>にswap関数を追加
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }

    val list = mutableListOf(1, 2, 3)
    // こんな感じで使える
    list.swap(0, 2) // swapメソッドのなかのthisはlistを表す


    // ジェネリクス関数としても追加できる
    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }


    // Nullableも拡張できる
    fun Any?.toString(): String {
        // thisはnullの可能性がある
        if (this == null) return "null"
        return toString()   // これはthis.toString()と同じだけど、thisは既にAny?でなくAny
    }


}



// List<T>にlastIndexプロパティを付け足す
// バッキングフィールドにはアクセスできない。関数を拡張するのと同様にgetterを拡張している
val <T> List<T>.lastIndex: Int
    get() = size - 1







