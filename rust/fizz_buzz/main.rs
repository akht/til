// FizzBuzz
fn fizzbuzz(n: usize) {
    for i in 0..n {
        if i % 15 == 0 {
            println!("FizzBuzz");
        } else if i % 3 == 0 {
            println!("Fizz");
        } else if i % 5 == 0 {
            println!("Buzz");
        } else {
            println!("{}", i);  // フォーマッティング
        }
    }
}

fn main() {
    fizzbuzz(20)
}