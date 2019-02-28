fn main1() {
    let v: Vec<i32> = Vec::new();
    println!("{:?}", v);

    let v2 = vec![1, 2, 3];
    println!("{:?}", v2);

    let mut v3 = Vec::new();
    v3.push(5);
    v3.push(6);
    v3.push(7);
    v3.push(8);
    println!("{:?}", v3);
}


fn main2() {
    let v = vec![1, 2, 3, 4, 5];

    let third: &i32 = &v[2];
    let third: Option<&i32> = v.get(2);

    // let does_not_exist = &v[100];    // これはpanicになる
    let does_not_exist = v.get(100);    // これはNoneだから大丈夫
}


fn main3() {
    let mut v = vec![1, 2, 3, 4, 5,];

    let first = &v[0];  // ここで不変な参照を借用しているので

    // v.push(0);  // これはできない


    // これが許されない理由
    // 新規要素をベクタの終端に追加すると、
    // ベクタが現在存在する位置に隣り合って要素を入れるだけの領域がなかった場合に、
    // メモリの新規確保をして古い要素を新しいスペースにコピーする必要があるかもしれないため。
    // その場合、最初の要素をさす参照は、解放されたメモリを指すことになってしまう。
}




// ベクタの値を走査する

fn main4() {
    let v = vec![100, 32, 57];

    for i in &v {           // 各要素に対する不変な参照を得る
        println!("{}", i);
    }


    let mut v2 = vec![100, 32, 57];

    for i in &mut v2 {  // 各要素への可変な参照を得る
        // 可変参照が参照している値を変更するには、参照外しをして値に辿りつかないといけない
        *i += 50;
    }

    println!("{:?}", v2);
}



// 新規ハッシュマップを生成

use std::collections::HashMap;

fn main5() {
    let mut scores = HashMap::new();

    scores.insert(String::from("blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    println!("{:?}", scores);
}


// ２つのベクタをzip()して生成

fn main6() {
    let teams = vec![String::from("Blue"), String::from("Yellow")];
    let initial_scores = vec![10, 50];

    // zip()することで、タプルのベクタを作り、それらをcollect()する
    // HashMap<_, _>という型注釈が必要なのは、collect()はいろんなデータ構造にまとめ上げることができるため
    // 型引数については型推論が効くので指定しなくて良い
    let scores: HashMap<_, _> = teams.iter().zip(initial_scores.iter()).collect();

    println!("{:?}", scores);
}


// ハッシュマップと所有権

fn main7() {
    let field_name = String::from("Favarite color");
    let field_value = String::from("Blue");

    let mut map = HashMap::new();
    map.insert(field_name, field_value);

    // Stringのような所有権のある値なら、値はムーブされ、所有権はハッシュマップに移るので
    // field_nameとfield_valueはこの時点で無効になる
    // println!("{}", field_name);  // これはコンパイルエラー
}


// ハッシュマップの値にアクセスする

fn main8() {
    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    let team_name = String::from("Blue");
    let score: Option<&i32> = scores.get(&team_name);   // getはOption<&T>を返す

    // ベクタのようにforループでキーと値のペアを走査することもできる
    for (key, value) in &scores {
        println!("{}: {}", key, value);
    }
}



// ハッシュマップを更新する


fn main() {
    overwrite();
    insertIfAbsent();
    updateValue();
}

// 値を上書きする
fn overwrite() {
    let mut scores = HashMap::new();
    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Blue"), 25);    // 単にinsertすると値は上書きされる

    println!("上書き: {:?}", scores);
}

// なければ値を挿入する
fn insertIfAbsent() {
    let mut scores = HashMap::new();
    scores.insert(String::from("Blue"), 10);

    scores.entry(String::from("Yellow")).or_insert(50);
    scores.entry(String::from("Blue")).or_insert(50);

    println!("なければ挿入: {:?}", scores);
}

// 古い値に基づいて値を更新する
fn updateValue() {
    let text = "hello world wonderful world";

    let mut map = HashMap::new();

    for word in text.split_whitespace() {
        let count = map.entry(word).or_insert(0);
        *count += 1;
    }

    println!("{:?}", map);
}

