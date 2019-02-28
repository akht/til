// panic!で回復不能なエラー

fn main1() {
    panic!("crash and burn");
}

// panic! バックトレースを使用する

fn main2() {
    let v = vec![1, 2, 3];

    v[99];
}

// Resultで回復可能なエラー

use std::fs::File;

fn main3() {
    let f = File::open("hello.txt");

    let f = match f {
        Ok(file) => file,
        Err(e) => panic!("There was a problem opening the file: {:?}", e),
    };
}

// 色々なエラーにマッチする

use std::io::ErrorKind;

fn main4() {
    let f = File::open("hello.txt");

    let f = match f {
        Ok(file) => file,
        Err(ref error) if error.kind() == ErrorKind::NotFound => match File::create("hello.txt") {
            Ok(fc) => fc,
            Err(e) => panic!("Tried to create file but there was a problem: {:?}", e),
        },
        Err(error) => panic!("There was a problem opening the file: {:?}", error),
    };
}

// エラー時にpanic!するショートカット unwrapとexpect

fn main5() {
    let f = File::open("hello.txt").unwrap();

    let f = File::open("hello.txt").expect("Filad to open hello.txt");
}

// エラーを委譲する
use std::io;
use std::io::Read;

fn read_username_from_file() -> Result<String, io::Error> {
    let f = File::open("hello.txt");

    let mut f = match f {
        Ok(file) => file,
        Err(e) => return Err(e), // エラーの早期リターン
    };

    let mut s = String::new();

    match f.read_to_string(&mut s) {
        Ok(_) => Ok(s),
        Err(e) => Err(e),
    }
}

fn main6() {
    let f = read_username_from_file().unwrap();
}

// エラー委譲のショートカット ?演算子
// ?演算子は戻り値がResultである関数内でしか使えない

fn read_username_from_file2() -> Result<String, io::Error> {
    let mut f = File::open("hello.txt")?;
    let mut s = String::new();
    f.read_to_string(&mut s)?;
    Ok(s)
}

// 処理をつなげて短くしたver
fn read_username_from_file3() -> Result<String, io::Error> {
    let mut s = String::new();

    File::open("hello.txt")?.read_to_string(&mut s)?;

    Ok(s)
}

fn main() {
    let f = read_username_from_file3().unwrap();
}
