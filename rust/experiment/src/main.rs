fn main1() {
    while_array();
    for_array();
    for_range();
}

fn while_array() {
    let a = [10, 20, 30, 40, 50];
    let mut index = 0;

    while index < 5 {
        println!("the value is: {}", a[index]);

        index += 1;
    }


    // これは添字の間違いが起きやすいだけでなく、遅いらしい
    // コンパイラが実行じにループの各回ごとの境界値チェックを行うようなコードを追加するため
}

fn for_array() {
    let a = [10, 20, 30, 40, 50];

    // 拡張for文が使える
    for element in a.iter() {
        println!("the value is: {}", element);
    }
}

fn for_range() {
    // (1,4]でrev()は逆順にする
    for number in (1..4).rev() {
        println!("{}!", number);
    }
    println!("LIFTOFF!!!")
}


fn main2() {
    let mut s = String::from("hello");

    s.push_str(", world!"); // push_str()関数は、リテラルをStringに付け加える

    println!("{}", s);  // => hello, world!
}

fn main3() {
    let s1 = String::from("hello");
    let s2 = s1;

    // println!("{}", s1);  // => コンパイルエラー
}

// 所有権があるのはわかった。
// じゃあ、ある文字列の長さを返す関数があったとして、
// それの結果を印字したい時には、わざわざ関数からタプルを返すようにして
// 所有権をムーブしなければならないのか？めんどくさすぎる
fn main4() {
    let s1 = String::from("hello");

    let (s2, len) = calculate_length(s1);

    println!("the length of '{}' is {}.", s2, len);
}

fn calculate_length(s: String) -> (String, usize) {
    let length = s.len();

    (s, length)
}

// 参照を使うことでムーブを起こさずに値を参照すすrことができる
fn main5() {
    let s1 = String::from("hello");

    let len = calculate_length2(&s1);

    println!("the length of '{}' is {}.", s1, len);
}

fn calculate_length2(s: &String) -> usize {
    s.len()
}


// test(s)の時点でsの値がムーブしてしまうのでprintln!で使えない
// fn main() {
//     let mut s = String::from("hello");

//     // s.push_str(", world!"); // push_str()関数は、リテラルをStringに付け加える

//     test(s);

//     println!("{}", s);  // => hello, world!
// }

// fn test(mut s: String) {
//     s.push_str(", world!");
// }

fn main6() {
    let mut s = String::from("hello");

    change(&mut s);

    println!("{}", s);
}

fn change(some_string: &mut String) {
    some_string.push_str(", world");
}

// ダングリングポインタ
fn main7() {
    let reference_to_nothing = dangle();
}

fn dangle() -> String {
    let s = String::from("hello");

    // これだとコンパイルエラーになる。
    // 参照を返すのに、sのライフタイムはスコープの最後であるこの箇所で終わるため
    // &s

    // これを返すためには、Stringを直接返す
    // 所有権はこの関数の呼び出し元にムーブされるので、何も解放されない
    s
}


fn main8() {
    let mut s = String::from("hello world");

    let word = first_word(&s);  // wordの中身は、値5になる

    s.clear();  // Stringを空にする。つまり、""と等しくなる



    println!("{}", word);   //=> 5

    // wordはまだ値5を保持しているが、もうこの値を有効に使用できる文字列は存在しない
    // wordは完全に無効になっている

    // wordの値は、Stringから切り離された値なので将来的にも有効な保証がない
    // 同期を取り続けるのも容易ではない

}

// 文字列中の最初の単語の終端を返す
fn first_word(s: &String) -> usize {
    // Stringオブジェクトをバイト配列に変換
    let bytes = s.as_bytes();

    // enumerate()で(インデックス, タプル)にすることができる
    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return i;
        }
    }

    s.len()
}


fn main9() {
    let s = String::from("hello world");

    // スライス = Stringの一部への参照
    let hello = &s[0..5];
    let world = &s[6..11];

    // 内部的には、スライスは、元の文字列の最初のバイトへのポインタと長さを保持する

    // このようにも書ける(0始まりの場合は省略できる)
    let slice = &s[0..2];
    let slice = &s[..2];

    // このようにも書ける(最後までの場合は省略できる)
    let slice = &s[3..s.len()];
    let slice = &s[3..];

    // どちらも省略すると文字列全体のスライスが得られる
    let slice = &s[..];
    let slice = &s[0..s.len()];

}


// 所有権はいらないので&Stringを受け取る
// 文字列スライスを意味する型は&str
fn first_word2(s: &String) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }

    &s[..]
}


fn main10() {
    let mut s = String::from("hello world");

    let word = first_word2(&s);

    // s.clear();  // コンパイルエラー

    // first_word2(&s)で不変の参照が存在することになる(不変借用)
    // その後、s.clear()でStringを切り詰めるために可変の参照を得ようとして失敗している
    // これまで見たように、不変の参照と可変の参照は同時に存在できない

}


// 引数の型をスライス(&str)にすることで、
// String値と&str値の両方に使えるより一般的なものにすることができる
fn first_word3(s: &str) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }

    &s[..]
}

fn main11() {
    let my_string = String::from("hello world");

    // first_word3はStringのスライスに対して機能する
    let word = first_word3(&my_string[..]);


    let my_string_literal = "hello world";

    // first_word3は文字列リテラルのスライスに対して機能する
    let word = first_word3(&my_string_literal[..]);

    // 文字列リテラルはすでに文字列スライスなので
    // スライス記法なしでも機能する
    let word = first_word3(my_string_literal);
}


fn main12() {
    let a = [1, 2, 3, 4, 5];

    let slice = &a[1..3];

    println!("{:?}", slice);    // => [2, 3]
}


struct User {
    username: String,
    email: String,
    sign_in_count: u64,
    active: bool,
}

fn main13() {
    // 構造体のインスタンスを生成
    // フィールドの順番は宣言順でなくてよい
    // mutをつけるとフィールドが可変になる(インスタンス全体が可変になる)
    // 一部のフィールドのみ可変にすることはできない
    let mut user1 = User {
        email: String::from("mail@example.com"),
        username: String::from("akht"),
        active: true,
        sign_in_count: 1,
    };

    // ドット記法でアクセスできる
    user1.email = String::from("hoge@example.com");
}

// User構造体のインスタンスを生成して返すビルダー関数
// 引数を省略して書くことが出来る
fn build_user(email: String, username: String) -> User {
    User {
        email: email,
        username: username,
        active: true,
        sign_in_count: 1,
    }
}

// フィールドと変数が同名の時にフィールド初期化省略記法を使える
fn build_user2(email: String, username: String) -> User {
    User {
        email,
        username,
        active: true,
        sign_in_count: 1,
    }
}

fn main14() {
    let user1 = User {
        email: String::from("mail@example.com"),
        username: String::from("akht"),
        active: true,
        sign_in_count: 1,
    };

    // 構造体更新記法なし
    let user2 = User {
        email: String::from("another@example.com"),
        username: String::from("tanaka"),
        active: user1.active,
        sign_in_count: user1.sign_in_count,
    };

    // 構造体更新記法を使った初期化
    let user3 = User {
        email: String::from("another@example.com"),
        username: String::from("tanaka"),
        ..user1
    };
}


// タプル構造体
// 同じようにi32を３つ保持する構造体だが、それぞれ独自の型になる
struct Color(i32, i32, i32);
struct Point(i32, i32, i32);

fn main15() {

    let black = Color(0, 0, 0);
    let origin = Point(0, 0, 0);

    //　どちらも0を３つ保持しているタプル構造体だが、当然、blackとoriginは異なる型である

    // ドット.indexでアクセスできる
    let r = black.0;
    let x = origin.0;
}


//  これではコンパイルエラーになる（ライフタイムを指定せずに構造体に参照を保持させようとしている）
// struct User2 {
//     username: &str,
//     email: &str,
//     sign_in_count: u64,
//     active: bool,
// }

// #[derive(Debug)]
// struct Rectangle {
//     width: u32,
//     height: u32,
// }

// fn main16() {
//     let rect1 = Rectangle {width: 30, height: 50 };

//     println!(
//         "The area of the rectangle is {} square pixcels.",
//         area(&rect1)
//         );
// }

// // 参照を受け取るようにする(所有権を奪わないようにするため)
// fn area(rectangle: &Rectangle) -> u32 {
//     rectangle.width * rectangle.width
// }

// fn main() {
//     let rect1 = Rectangle {width: 30, height: 50 };

//     println!("rect1 is {:#?}", rect1);
// }



#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

impl Rectangle {
    // メソッド(インスタンスメソッド的なもの)
    fn area(&self) -> u32 {
        self.width * self.height
    }

    // メソッド(インスタンスメソッド的なもの)
    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }

    // 関連関数(クラスメソッド的なもの)
    fn square(size: u32) -> Rectangle {
        Rectangle { width: size, height: size }
    }
}

fn main() {
    // 関連関数の呼び出し::で呼び出す
    let square = Rectangle::square(100);

    println!("{:#?}", square);
}

// 複数のimplブロックを存在させることもできる
impl Rectangle {
    fn hoge(&self) -> u32 {
        self.width - self.height
    }
}
impl Rectangle {
    fn fuga(&self, other: &Rectangle) -> bool {
        self.width > other.width
    }
}