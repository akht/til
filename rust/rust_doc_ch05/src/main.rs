#![allow(dead_code)]
#![allow(unknown_lints)]
#![allow(unused_mut)]

fn main1() {

    // 構造体をインスタンス化
    let mut user1 = User {
        email: String::from("someone@example.com"),
        username: String::from("someusername123"),
        active: true,
        sign_in_count: 1,
    };

    // インスタンスのフィールドを変更するには、インスタンス全体が可変でなければならない
    // 一部のフィールドのみを可変にすることはできない
    user1.email = String::from("anotheremail@example.com");
}


// ユーザーアカウントに関する情報を保持する構造体
struct User {
    username: String,
    email: String,
    sign_in_count: u64,
    active: bool,
}

fn build_user(email: String, username: String) -> User {
    User {
        email,
        username,
        active: true,
        sign_in_count: 1,
    }
}




// 構造体更新記法で他のインスタンスからインスタンスを生成する

fn main2() {
    let user1 = build_user(String::from("hoge@example.com"), String::from("bob"));

    // 構造体更新記法
    let user2 = User {
        email: String::from("fuga@example.com"),
        username: String::from("alice"),
        ..user1 // あとはuser1と同じという意味
    };
}



// タプル構造体（名前付きのタプル）

struct Color(i32, i32, i32);
struct Point(i32, i32, i32);

fn main3() {
    let black = Color(0, 0, 0);
    let origin = Point(0, 0, 0);

    // blackとoriginは、3つのi32からできているが別物である
}





// 構造体を使ったプログラム例

fn main4() {
    let width1 = 30;
    let height1 = 50;

    println!(
        "The area of the rectangle is {} square pixels.",
        area(width1, height1));
}

fn area(width: u32, height: u32) -> u32 {
    width * height
}



// area関数をタプルでリファクタリング
fn area2(dimensions: (u32, u32)) -> u32 {
    dimensions.0 * dimensions.1
}




// 構造体でリファクタリングする

struct Rectangle {
    width: u32,
    height: u32,
}

fn main5() {
    let rect1 = Rectangle { width: 30, height: 50 };

    println!(
        "The area of the rectangle is {} square pixels.",
        area3(&rect1)
    );
}

fn area3(rectangle: &Rectangle) -> u32 {
    rectangle.width * rectangle.height
}



// トレイとの継承で有用な機能を追加する
#[derive(Debug)]
struct Rectangle2 {
    width: u32,
    height: u32,
}

fn main6() {
    let rect1 = Rectangle2 { width: 30, height: 50 };

    println!("rect1 is {:#?}", rect1);
}




// メソッドを定義


#[derive(Debug)]
struct Rectangle3 {
    width: u32,
    height: u32,
}

// Rectangle3構造体上にareaメソッドを作る
impl Rectangle3 {
    fn area(&self) -> u32 {
        self.width * self.height
    }
}

fn main7() {
    let rec1 = Rectangle3 { width: 30, height: 50 };

    println!("The area of rectangle is {} square pixels.",
            rec1.area()
    );
}




// より引数の多いメソッド

fn main8() {
    let rect1 = Rectangle4 { width: 30, height: 50 };
    let rect2 = Rectangle4 { width: 10, height: 40 };
    let rect3 = Rectangle4 { width: 60, height: 45 };

    println!("Can rect1 hold rect2? {}", rect1.can_hold(&rect2));
    println!("Can rect1 hold rect3? {}", rect1.can_hold(&rect3));
}

#[derive(Debug)]
struct Rectangle4 {
    width: u32,
    height: u32,
}

impl Rectangle4 {
    fn area(&self) -> u32 {
        self.width * self.height
    }

    fn can_hold(&self, other: &Rectangle4) -> bool {
        self.width > other.width && self.height > other.height
    }
}



// 関連関数
// implブロック内のselfを引数に取らない関数

impl Rectangle4 {
    fn square(size: u32) -> Rectangle4 {
        Rectangle4 { width: size, height: size }
    }
}


fn main() {
    let sq = Rectangle4::square(25);

    println!("{:?}", sq);
}

