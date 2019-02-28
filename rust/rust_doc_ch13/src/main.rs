use std::thread;
use std::time::Duration;

fn simulated_expensive_calculation(intensity: u32) -> u32 {
    println!("calculating slowly...");
    thread::sleep(Duration::from_secs(2));
    intensity
}

fn generate_workout(intensity: u32, random_number: u32) {

    // クロージャにする
    // これだと実際に計算されるわけではないため呼び出されない箇所に余計な計算をさせない
    let expensive_closure = |num| {
        println!("calculating slowly...");
        thread::sleep(Duration::from_secs(2));
        num
    };

    if intensity < 25 {
        println!(
            "Today, do {} pushups!",
            expensive_closure(intensity)
        );

        println!(
            "Next, do {} situps!",
            expensive_closure(intensity)
        );
    } else {
        if random_number == 3 {
            println!("Take a break today! Remember to stay hydrated!");
        } else {
            println!(
                "Today, run for {} minutes!",
                expensive_closure(intensity)
            );
        }
    }
}

fn main1() {
    let simulated_user_specified_value = 10;
    let simulated_random_number = 7;

    generate_workout(
        simulated_user_specified_value,
        simulated_random_number
    );
}


fn main2() {
    let example_closure = |x| x;

    // ここでStringを引数にしてクロージャを呼び出すと
    // Stringと型推論されてクロージャに閉じこまれる
    let s = example_closure(String::from("hello"));

    // なので、ここでu32を引数にするとコンパイルエラーになる
    // let n = example_closure(5);
}

// クロージャをcalculationに、オプションの結果値をvalueに保持するCacher構造体を定義
struct Cacher<T>
    where T: Fn(u32) -> u32
{
    calculation: T,
    value: Option<u32>,
}

impl<T> Cacher<T>
    where T: Fn(u32) -> u32
{
    fn new(calculation: T) -> Cacher<T> {
        Cacher {
            calculation,
            value: None,
        }
    }

    fn value(&mut self, arg: u32) -> u32 {
        match self.value {
            Some(v) => v,
            None => {
                // argを引数にしてクロージャを実行
                let v = (self.calculation)(arg);
                self.value = Some(v);
                v
            },
        }
    }
}

fn generate_workout2(intensity: u32, random_number: u32) {

    let mut expensive_result = Cacher::new(|num| {
        println!("calculating slowly...");
        thread::sleep(Duration::from_secs(2));
        num
    });

    if intensity < 25 {
        println!(
            "Today, do {} pushups!",
            expensive_result.value(intensity)
        );

        println!(
            "Next, do {} situps!",
            expensive_result.value(intensity)
        );
    } else {
        if random_number == 3 {
            println!("Take a break today! Remember to stay hydrated!");
        } else {
            println!(
                "Today, run for {} minutes!",
                expensive_result.value(intensity)
            );
        }
    }
}

fn main3() {
    let simulated_user_specified_value = 10;
    let simulated_random_number = 7;

    generate_workout2(
        simulated_user_specified_value,
        simulated_random_number
    );
}


// クロージャで環境をキャプチャする
fn main5() {
    let x = 4;

    let equal_to_x = |z| z == x; // x=4をキャプチャする

    let y = 4;

    assert!(equal_to_x(y));
}

// 関数では環境をキャプチャできない
// fn main4() {
//     let x = 4;

//     fn equal_to_x(z: i32) -> bool { z == x }

//     let y = 4;

//     assert!(equal_to_x(y));
// }

fn main6() {
    let x = vec![1, 2, 3];

    // moveを指定して所有権を奪うことを強制する
    let equal_to_x = move |z| z == x;

    let y = vec![1, 2, 3];

    assert!(equal_to_x(y));
}

fn main7() {
    let v1 = vec![1, 2, 3];

    let v1_iter = v1.iter();

    for val in v1_iter {
        println!("Got: {}", val);
    }
}

#[test]
fn iterator_demonstration() {
    let v1 = vec![1, 2, 3];

    let mut v1_iter = v1.iter();    // next()を呼び出す時は可変にする必要がある

    assert_eq!(v1_iter.next(), Some(&1));
    assert_eq!(v1_iter.next(), Some(&2));
    assert_eq!(v1_iter.next(), Some(&3));
    assert_eq!(v1_iter.next(), None);
}

#[test]
fn iterator_sum() {
    let v1 = vec![1, 2, 3];

    let v1_iter = v1.iter();

    let total: i32 = v1_iter.sum();

    assert_eq!(total, 6);

}

fn main8() {
    let v1: Vec<i32> = vec![1, 2, 3];

    // イテレータアダプタは怠惰なので、消費するまでは何もしない
    // v1.iter().map(|x| x + 1);

    // collectでイテレータを消費し、結果の値をコレクションデータ型に集結させる
    let v2: Vec<_> = v1.iter().map(|x| x + 1).collect();

    assert_eq!(v2, vec![2, 3, 4]);
}


#[derive(PartialEq, Debug)]
struct Shoe {
    size: u32,
    style: String,
}

fn shoes_in_my_size(shoes: Vec<Shoe>, shoe_size: u32) -> Vec<Shoe> {
    shoes.into_iter()   // ベクタの所有権を奪うイテレータ
        .filter(|s| s.size == shoe_size)
        .collect()
}

#[test]
fn filters_by_size() {
    let shoes = vec![
        Shoe { size: 10, style: String::from("sneaker") },
        Shoe { size: 13, style: String::from("sandal") },
        Shoe { size: 10, style: String::from("boot") },
    ];

    let in_my_size = shoes_in_my_size(shoes, 10);

    assert_eq!(
        in_my_size,
        vec![
            Shoe { size: 10, style: String::from("sneaker") },
            Shoe { size: 10, style: String::from("boot") },
        ]
    );
}

struct Counter {
    count: u32,
}

impl Counter {
    fn new() -> Counter {
        Counter { count: 0 }
    }
}

impl Iterator for Counter {
    type Item = u32;

    fn next(&mut self) -> Option<Self::Item> {
        self.count += 1;

        if self.count < 6 {
            Some(self.count)
        } else {
            None
        }
    }
}

fn main() {
    let mut counter = Counter::new();

    assert_eq!(counter.next(), Some(1));
    assert_eq!(counter.next(), Some(2));
    assert_eq!(counter.next(), Some(3));
    assert_eq!(counter.next(), Some(4));
    assert_eq!(counter.next(), Some(5));
    assert_eq!(counter.next(), None);
}


#[test]
fn using_other_iterator_trait_methods() {
    let sum: u32 = Counter::new().zip(Counter::new().skip(1))
                                 .map(|(a, b)| a * b)
                                 .filter(|x| x % 3 == 0)
                                 .sum();

    assert_eq!(18, sum);
}


#[test]
fn difference_between_iterator_trait_and_iter() {

    let mut counter = Counter::new();
    let v1 = vec![counter.next(), counter.next(), counter.next(), counter.next(), counter.next(), counter.next()];
    let iter: Vec<_> = v1.into_iter().collect();

    // iterだとOption型になる
    assert_eq!(iter, vec![Some(1), Some(2), Some(3), Some(4), Some(5), None]);



    let iterator_trait: Vec<_> = Counter::new().collect();

    // Iteratorトレイトのデフォルト実装を使うとOptionがunwapされる
    // かわりに、Noneがきたらそこで終わる
    assert_eq!(iterator_trait, vec![1, 2, 3, 4, 5]);
}
