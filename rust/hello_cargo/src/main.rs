fn main() {
    let mut s = String::from("hello, ");
    s.push_str("world");

    println!("{}", s);
}

// 実行方法

// cargo check チェック

// cargo build　ビルド
// ./target/debug/hoge で実行

// cargo run ビルドと実行をいっぺんにやってくれる
