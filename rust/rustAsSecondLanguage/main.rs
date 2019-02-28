fn main0() {
    // rebind();
    // reassign();

    // main3();
    // main4();
    // main5();
    // main6();
    // main7();
    // main8();
    // main9();
    // main10();
    // main11();
    // main12();
    main13();
}

// mutはあくまで変数につく属性なので、変数ごとに設定できる
fn main1() {
    // イミュータブルな変数
    let x = 1 + 2;

    // ミュータブルな変数に束縛できる
    let mut y = x;
    y = 5;

    // さらにイミュータブルな変数に束縛できる
    let z = y;
    // z = 10;  // これはエラーになる

    println!("{}", z);  // => 5
}

// 変数への再代入はできないが、再束縛はできる
fn main2() {
    // １つ目のxを束縛する
    let x: i32 = 1;
    println!("{}", x); // => 1

    // ２つ目のxを束縛する。これは先のxとは別物
    let x: &str = "abc";

    // 以後、xはabcを指すようになる
    println!("{}", x); // => abc
}

// 再束縛
fn rebind() {
    let sum = 0;
    for i in 0..10 {
        // 新しい束縛を作っているので上の束縛には影響がない
        let sum = sum + 1;
    }
    println!("{}", sum); // => 0
}

// 再代入
fn reassign() {
    let mut sum = 0;
    for i in 0..10 {
        // 上の束縛の値を書き換える
        sum = sum + i;
    }
    println!("{}", sum); // => 45
}

// 参照型
fn main3() {

    // イミュータブルな束縛を作っておく
    let mut x = 1;
    // 「&値」で参照がとれる
    // yの参照(値のありか)に、xの参照(値のありか)を束縛する
    let y:&isize = &x;



    // ミュータブルな束縛を作っておく
    let mut a = 1;
    // 「&mut 値」でミュータブルな参照がとれる。値もミュータブルである必要がある
    let b = &mut a;
    // 「*参照 = 値」で代入できる。これは「&mut」型ならいつでも可能
    *b = 2;
    // bの参照先が変わっている
    // aは一定の条件を満たしている(copyな)ため参照外しができる
    println!("b = {}", *b); // => 2
}

// 配列とスライス
fn main4() {
    let a: [isize;3] = [1, 2, 3];
    // 「&配列」でスライスが作れる
    let b: &[isize] = &a;
    // スライスをフォーマットする時はプレースホルダを「{:?}」にする
    println!("{:?}", b);    // => [1, 2, 3]
    for elm in b {
        println!("{}", elm);
    }


    // インデックスを使って要素にアクセスできる
    println!("{:?}", b[0]); // =>  1
}

// 文字列
fn main5() {
    // &strはto_string()メソッドでStringにできる
    let mut a: String = "abc".to_string();

    // 少しややこしいが、Stringに&strを足すとStringができる
    // &strにStringを足したり、StringにStringを足したりはできない
    a += "def";
    println!("{}", a);  // => abcdef


    // to_string()は色々な型に用意されている
    let x = 1.0.to_string();
    println!("{}", x);  // => 1

    // Stringを&strにするにはas_str()が使える
    a += x.as_str();
    println!("{}", a);  // => abcdef1
}

// タプル
fn main6() {
    // 型を混合したタプルが作れる
    let a: (isize, f64, &str) = (1, 1.0, "abc");

    // タプル.インデックスでタプルの要素にアクセスできる
    println!("{}, {}, {}", a.0, a.1, a.2);  // => 1, 1, abc
}

// 関数
fn main7() {
    // 関数呼び出し
    println!("{}", add(2, 3));  // => 5

    // 関数を変数に束縛できる
    let func: fn(isize, isize) -> isize = add;

    // 変数に束縛した関数も同じように呼び出せる
    let a = func(3, 4);
    println!("{}", a);  // => 7

}

// 関数を定義
fn add(x: isize, y: isize) -> isize {
    x + y
}

// match式(他の言語のswitch文, case文のようなもの)
fn main8() {

    // match 値 {パターン => 処理, ..}の形で書く
    match 10 {
        // リテラルへのマッチ
        0 => println!("{}", 0),

        // レンジパターンが書ける
        1...10 => println!("small number"),

        // 変数パターンで受け取ると残りの可能性を全て受け、変数をその値に束縛する
        n => println!("{}", n),
    }

    match (1.0, 1) {
        // タプルパターンでタプルを分解できる。さらにパターンの入れ子もできる
        (0.0, 0) => println!("all zero"),

        // 部分的に変数パターンを使うこともできる
        (f, 0...10) => println!("float: {} with small number", f),

        // _は値を捨てるパターン
        _ => println!("other tuple"),
    }
}

fn main9() {

    // 最後が式なのでusizeを返していることになるが、main9()は戻り値()でないといけない
    // factorial(10)    // => コンパイルエラー

    // ;をつけることで文になり、コンパイルが通る
    factorial(10);
}

fn factorial(n :usize) -> usize {
    // ifは式なので関数の最後に置くと値を返せる
    if n == 0 {
        1
    } else {
        n * factorial(n - 1)
    }
}

// 所有権
fn main10() {

    let s = "this is a resource".to_string();

    // ここで、sが束縛されている文字列の所有権がtに移る
    // 以後、sは使えない
    let t = s;

    // ここで、文字列の所有権がtからprint_stringに移る
    // 以後、tは使えない
    print_string(t);

    // もう一度tを使おうとしてもエラー
    // print_string(t);

    // 同じくsを使おうとしてもエラー
    // print_string(s);

    // しかしこれだとprint_string(t)を２回呼べないということになる
    // それでは不便なので所有権の貸し出し=借用の機能がある
}

fn print_string(s: String) {
    println!("{}", s);

    // sはこの関数の終わりで消滅する
    // このタイミングでsのメモリも自動で解放される
}


// イミュータブルな参照
fn main11() {
    let s = "this is a resource".to_string();

    // 参照ひとつめ
    let t = &s;

    // 参照ふたつめ。同時に存在できる
    ref_string(&s);
}

fn ref_string(s: &String) {
    println!("{}", s);
}


// ミュータブルな参照
fn main12() {
    let mut s = "this is a resource".to_string();
    // ミュータブルな参照1つめ。
    let t = &mut s;
    // ミュータブルな参照2つめはエラー。
    // refmut_string(&s);
}

fn refmut_string(s: &mut String) {
    // ここでsに対して変更を加えるなどの操作も可能。
    println!("{}", s);
}


// ミュータブルな参照とイミュータブルな参照は共存できない
fn main13() {
    // ベクトルを用意する
    let mut vec = vec![1, 2, 3];

    // ベクトルの要素への参照を取り出す
    // ベクトルをイミュータブルに参照する
    for i in vec.iter() {
        // すでにベクトルはイミュータブルに参照されているので
        // ここでベクトルを変更しようとするとエラー
        // 実際、これを許すと無限ループになってしまう
        // vec.push(i * 2);
    }
}

fn main14() {
    // 本来はsのライフタイムはこの関数の最後まで
    let s = "owned data".to_string();

    {
        // sはここでムーブしてしまうのでここでライフタイムが終わる
        // tのライフタイムはこのブロックの終わりまで
        let t = s;
    }
    // ここではtにもsにもアクセスできない
    // println!("{}", s);  // エラー
    // println!("{}", t);  // エラー


    // ライフタイムと参照の関係
    {
        let s = "owned data".to_string();

        // ここでsへの参照を作る
        // この参照はこのブロックの最後で死ぬが、sの方が長生きしないといけない
        let ref_s = &s;

        // 例えば以下のようにsのライフタイムをref_sより先に終わらせようとするとエラーになる
        // let t = s;
    }

}

// ジェネリクスを使った関数定義
fn pair<T, S>(t: T, s: S) -> (T, S){ (t, s) }

fn main15() {
    // T = i32, S = f64で呼び出す
    let i = pair(1, 1.0);

    // 型を明示する方法もある
    let i2 = pair::<isize, f64>(1, 1.0);

    // T = &str, S = Stringで呼び出す
    let s = pair("str", "string".to_string());
}


// Unit構造体(データを持たない)
struct Dummy;

// タプル構造体(フィールドに名前がない)
struct Point(f64, f64);

// 通常の構造体
struct Color {
    r: u8,
    g: u8,
    b: u8,
}

fn main16() {
    // Unit構造体は名前でそのまま初期化
    let dummy = Dummy;



    // タプル構造体は関数のように初期化
    // 実際、関数として扱うことが出来る
    let point = Point(0.0, 0.0);

    // タプル構造体のフィールドへのアクセス
    let x = point.0;



    // 普通の構造体の初期化
    let black = Color { r: 0, g: 0, b: 0 };

    // 普通の構造体のフィールドへのアクセス
    let r = black.r;

}


struct Celsius(f64);
struct Kelvin(f64);

//  「impl 型名」で、型に対する実装を書ける
impl Celsius {
    // ブロックの中には関数が欠ける
    // 第一引数が self, &mut self, &self, Box<self> の場合はメソッドとなる
    fn to_kelvin(self) -> Kelvin {
        // selfを通じてフィールドにアクセスできる(thisのようなもの)
        Kelvin(self.0 + 273.15)
    }

    // 第一引数がself系でない場合は関連関数(クラスメソッドのようなもの)になる
    fn from_kelvin(k: Kelvin) -> Self {
        Celsius(k.0 - 273.15)
    }
}

fn main() {
    let absolute_zero = Kelvin(0.0);
    let triple_point = Celsius(0.0);

    // 関連関数は 型名::関数名 で呼び出す
    let celsius = Celsius::from_kelvin(absolute_zero);

    // メソッドは 値.関数名(引数) で呼び出す
    let kelvin = triple_point.to_kelvin();
}