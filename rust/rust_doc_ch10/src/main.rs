// ジェネリック型、トレイト、ライフタイム

// 関数を抽出することで重複を取り除く

fn largest(list: &[i32]) -> i32 {
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}

fn main1() {
    let number_list = vec![34, 50, 25, 100, 65];

    let result = largest(&number_list);
    println!("The largest number is {}", result);

    let number_list = vec![102, 34, 6000, 89, 54, 2, 43, 8];

    let result = largest(&number_list);
    println!("The largest number is {}", result);
}

// ジェネリックなデータ型

// largest_charと中身が同じ！
fn largest_i32(list: &[i32]) -> i32 {
    let mut largest = list[0];

    for &item in list {
        if item > largest {
            largest = item;
        }
    }

    largest
}

// largest_i32と中身が同じ！
fn largest_char(list: &[char]) -> char {
    let mut largest = list[0];

    for &item in list {
        if item > largest {
            largest = item;
        }
    }

    largest
}

// ジェネリクスで書き直す
// しかしTに対して二項演算子>が適用できないのでコンパイルできない
// fn largest2<T>(list: &[T]) -> T {
//     let mut largest = list[0];

//     for &item in list.iter() {
//         if item > largest {
//             largest = item;
//         }
//     }

//     largest
// }

fn main2() {
    let number_list = vec![34, 50, 25, 100, 65];

    // let result = largest(&number_list);
    // println!("The largest number is {}", result);

    let char_list = vec!['y', 'm', 'a', 'q'];

    // let result = largest(&char_list);
    // println!("The largest char is {}", result);
}

// トレイト：共通の振る舞いを定義する

pub trait Summary {
    fn summarize_author(&self) -> String;

    // 中身を書けばそれがデフォルト実装になる
    fn summarize(&self) -> String {
        format!("(Read more from {}...)", self.summarize_author())
    }
}

pub struct NewsArticle {
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

impl Summary for NewsArticle {
    fn summarize_author(&self) -> String {
        format!("@{}", self.author)
    }
}

pub struct Tweet {
    pub username: String,
    pub content: String,
    pub reply: bool,
    pub retweet: bool,
}

impl Summary for Tweet {
    fn summarize_author(&self) -> String {
        format!("@{}", self.username)
    }
}

fn main3() {
    let tweet = Tweet {
        username: String::from("horse_ebooks"),
        content: String::from("of course, as you probably already know, poeple"),
        reply: false,
        retweet: false,
    };

    println!("1 new tweet: {}", tweet.summarize());

    let article = NewsArticle {
        headline: String::from("Penguins win the Stanley Cup Championship!"),
        location: String::from("Pittsburgh, PA, USA"),
        author: String::from("Iceburgh"),
        content: String::from(
            "The Pittsburgh Penguins once again are the best hockey team in the NHL.",
        ),
    };

    println!("New article available! {}", article.summarize());
}

// トレイト境界を使用したジェネリクス
fn notify<T: Summary>(item: T) {
    println!("Breaking News! {}", item.summarize());
}

use std::fmt::Debug;
use std::fmt::Display;

// 複数のトレイト境界を指定
fn some_function<T: Display + Clone, U: Clone + Debug>(t: T, u: U) -> i32 {
    1
}

// where節内にトレイト境界を指定する
fn some_function2<T, U>(t: T, u: U) -> i32
where
    T: Display + Clone,
    U: Clone + Debug,
{
    1
}

// トレイト境界でlargest関数を修正

fn largest2<T: PartialOrd + Copy>(list: &[T]) -> T {
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}

fn main4() {
    let number_list = vec![34, 50, 25, 100, 65];

    let result = largest2(&number_list);
    println!("The largest number is {}", result);

    let char_list = vec!['y', 'm', 'a', 'q'];

    let result = largest2(&char_list);
    println!("The largest char is {}", result);
}

// 関数のジェネリックなライフタイム

fn main5() {
    let string1 = String::from("abcd");
    let string2 = "xyz";

    let result = longest(string1.as_str(), string2);
    println!("The longest string is {}", result);
}

fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}

fn main6() {
    let string1 = String::from("long string is long");
    let result;
    {
        let string2 = String::from("xyz");
        result = longest(string1.as_str(), string2.as_str());
    }

    // longestから帰るresultは２つの引数のライフタイプと同じで、
    // さらに小さいスコープの方に決まるのでstring2のスコープと同じなる
    // よってブロックを抜けた後のこの場所ではresultは無効な参照となる
    // println!("The longest string is {}", result);
}

// ライフタイムの観点で思考する

// どこにライフタイムを指定する注釈が必要かは、関数が何をするかによる
// 例えばこの関数では、xとyの引数のうち、常にxを返す
// つまり戻り値にはyのライフタイムは関係ないので指定しなくてよい
fn longest2<'a>(x: &'a str, y: &str) -> &'a str {
    x
}

// 関数から参照を返す際、戻り値型のライフタイム引数は、引数のうちどれかのライフタイム引数と一致する必要がある。
// 返される参照が引数のどれかを参照していなければ、
// その関数内で生成された値を参照しているということなので、その値が関数の末端でスコープを抜けると
// ダングリング参照になってしまう(resultが関数の末端でスコープを抜けるときに片付けられてしまうため)
// ↓の関数はコンパイルできない
// fn longest3<'a>(x: &str, y: &str) -> &'a str {
//     let result = String::from("really long string");
//     result.as_str()
// }

// 構造体定義のライフタイム注釈
struct ImportantExcerpt<'a> {
    part: &'a str,
}

fn main7() {
    let novel = String::from("Call me Ishmael. Some years ago...");
    let first_sentence = novel.split('.').next().expect("Could not find a '.'");
    let i = ImportantExcerpt {
        part: first_sentence,
    };

    println!("{}", i.part);
}

// ライフタイム省略

// 関数やメソッドにおいて、コンパイラがライフタイムを推論できるときはライフタイム注釈を省略できる
// コンパイラは以下の３つのルールを適用して、すべての参照のライフタイムが推論できればコンパイルを通す
//
// 1. 参照である各引数に、それぞれ独自のライフタイムを設定する
//   fn foo<'a>(x: &'a i32)
//   fn bar<'a, 'b>(x: &'a i32, y: &'b i32)
//
// 2. 入力ライフタイム引数が１つだけのときは、そのライフタイムを全ての出力ライフタイム引数に代入する
//   fn foo<'a>(x: &'a i32) -> &'a i32
//
// 3. メソッドの場合。
//    複数の入力ライフタイム引数があるが、メソッドなのでそのうちのひとつが&selfや&mut selfだったら
//    selfのライフタイムを全出力ライフタイム引数に代入する

// メソッド定義におけるライフタイム注釈

impl<'a> ImportantExcerpt<'a> {
    fn level(&self) -> i32 {
        3
    }
}

impl<'a> ImportantExcerpt<'a> {
    fn announce_and_return_part(&self, announcement: &str) -> &str {
        println!("Attention please: {}", announcement);
        self.part
    }
}

// 静的ライフタイム

fn main() {
    // 'staticは静的ライフタイムで、プログラム全体の期間を示す
    // 文字列リテラルは全て'staticライフタイムになる
    // なぜなら、文字列のテキストはプログラムのバイナリに直接格納されるため
    let s: &'static str = "I have a static lifetime";

    println!("{}", s);
}

// ジェネリックな型引数、トレイト境界、ライフタイムを一度に指定

fn longest_with_an_announcement<'a, T>(x: &'a str, y: &'a str, ann: T) -> &'a str
where
    T: Display,
{
    println!("Announcement! {}", ann);
    if x.len() > y.len() {
        x
    } else {
        y
    }
}
