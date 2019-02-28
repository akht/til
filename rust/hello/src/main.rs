use std::io::Write;
use std::str::FromStr;

fn main() {
    // ベクタの中身は型推論できるので書く必要はない
    let mut numbers = Vec::new();

    for arg in std::env::args().skip(1) {
        // from_str()からはResult型が返ってくる
        // Ok(v)ならexpect()で値vが返り、Err(e)ならメッセージを出力してプログラムを中断する
        numbers.push(u64::from_str(&arg)
                        .expect("error parsing argument"));
    }

    if numbers.len() == 0 {
        // unwrap()はエラーメッセージの出力が成功したかどうかをチェックする無愛想な書き方
        // 失敗した場合にはエラーメッセージを出力する
        writeln!(std::io::stderr(), "Usage: gcd NUMBER ...").unwrap();
        std::process::exit(1);
    }

    let mut d = numbers[0];
    for m in &numbers[1..] {
        d = gcd(d, *m);
    }

    println!("The greatest common divisor of {:?} is {}",
             numbers, d);

}

// 最大公約数を求める関数
fn gcd(mut n: u64, mut m: u64) -> u64 {
    assert!(n != 0 && m != 0);
    while m != 0 {
        if m < n {
            let t = m;
            m = n;
            n = t;
        }
        m = m % n;
    }
    n
}

#[test]
fn test_gcd() {
    // gcd()に対するテスト
    // cargo testで実行できる

    assert_eq!(gcd(14, 15), 1);

    assert_eq!(gcd(2 * 3 * 5 * 11 * 17,
                   3 * 7 * 11 * 13 * 19),
               3 * 11);
}