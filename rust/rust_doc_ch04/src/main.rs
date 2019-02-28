#![allow(dead_code)]
#![allow(unknown_lints)]
#![allow(unused_mut)]

fn main1() {
    let mut s = String::from("hello");
    s.push_str(", world");
    println!("{}", s);
}

fn main2() {
    let x = 5;
    let y = x;
    // xの値をコピーしてyに束縛する
    // 二つの変数x, yが存在し、両方とも値は5になった



    let s1 = String::from("hello");
    let s2 = s1;
    // println!("{}, world!", s1); // 値がs2にムーブされているのでs1は使用できない

    let s3 = String::from("hello");
    let s4 = s3.clone();
    println!("{}, world", s3);  // ヒープもコピーされるのでmoveが起こらないためs3が無効になっていない
}



// 所有権と関数
fn main3() {
    let s = String::from("hello");  // sがスコープに入る


    takes_ownership(s);              // sの値が関数にムーブされる
                                    // この位置ではsはもう有効ではない

    let x= 5;                       // xがスコープに入る

    makes_copy(x);                  // xも関数にムーブされるが
                                    // i32はCopyなので、この後にxを使っても大丈夫
}

fn takes_ownership(some_string: String) {    // some_stringがスコープに入る
    println!("{}", some_string);
}   // ここでsome_stringがスコープを抜け、drop関数が呼ばれる。ヒープ上のメモリが解放される

fn makes_copy(some_integer: i32) {  // some_integerがスコープに入る
    println!("{}", some_integer);
}   // ここでsome_integerがスコープを抜ける。何も特別なことはない





// 戻り値とスコープ

fn main4() {
    let s1 = gives_ownership();         // gives_ownershipは、戻り値をs1にムーブする


    let s2 = String::from("hello");     // s2がスコープに入る

    let s3 = takes_and_gives_back(s2);  // s2はtakes_and_gives_backにムーブされ
                                        // 戻り値もs3にムーブされる
}   // ここで、s3はスコープを抜け、ドロップされる。
    // s2もスコープを抜けるが、ムーブされているので何も起きない。
    // s1もスコープを抜け、ドロップされる

fn gives_ownership() -> String {            // gives_ownershipは、戻り値を
                                            // 呼び出した関数にムーブする

    let some_string = String::from("hello");// some_stringがスコープに入る

    some_string                             // some_stringが返され、呼び出し元関数にムーブされる
}

// takes_and_gives_backは、Stringをひとつ受け取り、返す
fn takes_and_gives_back(a_string: String) -> String {   // a_stringがスコープに入る

    a_string    // a_stringが返され、呼び出し元関数にムーブされる
}



// 所有権を得ては返す、というのを全ての関数でするとめんどくさい
// こんな感じでタプルで元の値を返す？
// 全ての関数でこんなことをしたくないので解決する方法がある

fn main5() {
    let s1 = String::from("hello");

    let (s2, len) = calculate_length_old(s1);   // s1はcalculate_lengthにムーブされるが
                                                // 戻り値としてs2にまた返ってくる

    println!("The length of '{}' is {}.", s2, len);
}

// 文字列sを使って計算したいけど、所有権は保持させたくないので元の値を戻り値として返そう
fn calculate_length_old(s: String) -> (String, usize) {
    let length = s.len();

    (s, length)
}



// 値の所有権をもらう代わりに、
// 引数としてオブジェクトへの参照を取るようにして↑の問題を解決する
// これは借用と呼ばれる

fn main6() {
    let s1 = String::from("hello");

    let len = calculate_length(&s1);    // s1の参照を渡す(所有権は渡さない)

    println!("The length of '{}' is {}.", s1, len);
}

// 参照をもらう関数(所有権は不要)
fn calculate_length(s: &String) -> usize {  // sはStringへの参照
    s.len()
} // ここで、sはスコープを抜ける。しかし参照しているだけで所有権を持っているわけではないので
  // 何も起こらない




// 可変な参照

fn main7() {
    let mut s = String::from("hello");  // 変数sをmutにしなければならない

    change(&mut s);                     // &mut sで可変な参照を渡す
}

fn change(some_string: &mut String) {   // 引数で可変な参照&mut Stringを受け取る
    some_string.push_str(", world");
}






fn main8() {
    let mut s = String::from("hello");

    let r1 = &mut s;
    // let r2 = &mut s; // sの可変な参照が同一スコープに２つ存在することになるのでコンパイルエラーになる
}

fn main9() {
    let mut s = String::from("hello");

    {

        let r1 = &mut s;

    } // r1はここでスコープを抜けるので、この後にはsの可変参照を作ることができる

    let r2 = &mut s;
}


// 不変な参照が存在しているスコープでは、可変な参照を作ることはできない
// というより、可変な参照と不変な参照は同時に存在できない
// 不変な参照はどこで値が変わることなんて予想してないので
fn main10() {
    let mut s = String::from("hello");

    let r1 = &s;    // 不変な参照
    let r2 = &s;    // 不変な参照なので問題なし
    // let r3 = &mut s;// 可変な参照なのでコンパイルエラー
}




/*

// ダングリングポインタが生成されないようになっている

fn main() {
    let reference_to_nothing = dangle();
}

fn dangle() -> &String {    // dangleはStringへの参照を返す

    let s = String::from("hello");  // sは新しいString

    &s  // String sへの参照を返す
}   // ここで、sはスコープを抜けドロップされる。そのメモリは解放される
    // 危険

    // sはdangle内で生成されているので、dangleのコードが終わったらsはかいほうされるが
    // そこへの参照を返そうとしている
    // つまりこの参照は無効なStringを指していると思われるのでよくない。コンパイラによって阻止される

    // ここでの解決策は、Stringを直接返すこと。参照を返すのではなく。
    // そうすれば所有権はムーブされ、何も解放されることはない

*/



// 意味をなさない値を作れてしまう例

fn main11() {
    let mut s = String::from("hello");

    let word = first_word(&s); // wordの中身は値5になる

    s.clear();  // Stringを空にする。つまり、""と等しくなる

    // wordはまだ値5を保持しているが、もうこの値を有効に使用できる文字列は存在しない
    // wordは完全に意味のない値になった！
    // しかしこれはなんのエラーもなくコンパイルが通る。
    // s.clear()の後にwordを使ってもコンパイルが通る。
}

// この関数には問題がある
// usize型を単独で返しているが、これは&Stringの文脈でのみ意味を持つ数値
// 言い換えると、Stringから切り離された値なので、将来的にも有効である保証がない
fn first_word(s: &String) -> usize {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return i;
        }
    }

    s.len()
}




// 文字列のスライスを使う

fn main12() {
    let mut s = String::from("hello world");

    let word = first_word2(&s); // 不変な参照を借用している

    // s.clear();  // エラー   clearするために可変な参照を得よとしている
                // 不変な参照と可変な参照は同時に存在できないのでエラーになる
}



// スライスを返すようにしたもの
fn first_word2(s :&String) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }

    &s[..]
}



// 引数としての文字列スライス


fn main() {
    let my_string = String::from("hello world");

    // first_word3はStringのスライスに対して機能する
    let word = first_word3(&my_string[..]);


    let my_string_literal = "hello world";

    // first_word3は文字列リテラルのスライスに対して機能する
    let word = first_word3(&my_string_literal[..]);

    // 文字列リテラルはすでに文字列スライスなので、
    // スライス記法なしでも機能する
    let word = first_word3(my_string_literal);
}

// 引数の型を&Stringではなく&strにする
// こうすることでStringと&strの両方に使えるようになる
fn first_word3(s: &str) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }

    &s[..]
}