
// Enumを定義する

// IPアドレスのEnum
enum IpAddrKind {
    V4,
    V6,
}

fn main1() {
    let four = IpAddrKind::V4;
    let six = IpAddrKind::V6;
}



// Enumの各列挙子にデータを紐付ける
enum IpAddr {
    V4(String),
    V6(String),
}

fn main2() {
    let home = IpAddr::V4(String::from("127.0.0.1"));
    let loopback = IpAddr::V6(String::from("::1"));
}



// 各列挙子に紐付けるデータの型と量は異なってもいい
// これは構造体では実現できない
enum IpAddr2 {
    V4(u8, u8, u8, u8),
    V6(String),
}

fn main3() {
    let home = IpAddr2::V4(127, 0, 0, 1);
    let loopback = IpAddr2::V6(String::from("::1"));
}


// 幅広い種類の型を持つEnum
#[derive(Debug)]
enum Message {
    Quit,
    Move { x: i32, y: i32 },
    Write(String),
    ChangeColor(i32, i32, i32),
}

// enumにもimplブロックを使ってメソッドを定義できる
impl Message {
    fn call(&self) {
        // do something
        println!("{:?}", self);
    }
}

fn main4() {
    let m = Message::Write(String::from("hello"));
    m.call();
}


// Option<T>

fn main5() {
    let some_number = Some(5);
    let some_string = Some("a string");

    let absent_number: Option<i32> = None;  // 型を指定する
}




// matchフロー制御演算子

enum Coin {
    Penny,
    Nickel,
    Dime,
    Quarter,
}

fn value_in_cents(coin: Coin) -> u32 {
    match coin {
        Coin::Penny => 1,
        Coin::Nickel => 5,
        Coin::Dime => 10,
        Coin::Quarter => 25,
    }
}

fn value_in_cents2(coin: Coin) -> u32 {
    match coin {
        Coin::Penny => {
            println!("Luckey Penny!");
            1
        },
        Coin::Nickel => 5,
        Coin::Dime => 10,
        Coin::Quarter => 25,
    }
}



// 値に束縛されるパターン

#[derive(Debug)]
enum UsState {
    Alabama,
    Alaska,
    // などなど
}

enum Coin2 {
    Penny,
    Nickel,
    Dime,
    Quarter(UsState),   // こいつだけが情報を保持している
}

fn value_in_cents3(coin: Coin2) -> u32 {
    match coin {
        Coin2::Penny => 1,
        Coin2::Nickel => 5,
        Coin2::Dime => 10,
        Coin2::Quarter(state) => {
            println!("State quarter from {:?}!", state);
            25
        },
    }
}



// Option<T>とのマッチ

fn plus_one(x: Option<i32>) -> Option<i32> {
    match x {
        None => None,
        Some(i) => Some(i + 1),
    }
}

fn main6() {
    let five = Some(5);
    let six = plus_one(five);
    let none = plus_one(None);
}


// _というプレースホルダー

fn main7() {
    let some_u8_value = 0u8;

    match some_u8_value {
        1 => println!("one"),
        3 => println!("three"),
        5 => println!("five"),
        7 => println!("seven"),
        _ => (),
    }
}



// if let で簡潔なフロー制御

fn main8() {
    // Option<u8>の値が3の時だけマッチして何かしたい時

    let some_u8_value = Some(3);

    match some_u8_value {
        Some(3) => println!("three"),
        _ => (),
    }
}

// いちいち_を書いて網羅的なmatchを書くのはめんどうなので
// ↓のように if let を使う

fn main9() {
    let some_u8_value = Some(3);

    if let Some(3) = some_u8_value {
        println!("three");
    }
}


// if let はelseも書ける

fn main() {
    let coin = Coin2::Quarter(UsState::Alaska);

    let mut count = 0;

    match coin {
        Coin2::Quarter(state) => println!("State quarter from {:?}!", state),
        _ => count += 1,
    }

    // これはif letを使ってこう書ける

    let coin2 = Coin2::Quarter(UsState::Alaska);

    if let Coin2::Quarter(state) = coin2 {
        println!("State quarter from {:?}!", state);
    } else {
        count += 1;
    }

}

