// 偶数二乗合計
fn square_sum(n: isize) -> isize {
    (0..n)
        .filter(|i| i % 2 == 0)
        .map(|i| i * i)
        .sum()
    
    // returnを書かなくても最後の値が返り値になる
}

fn main() {
    println!("{}", square_sum(10));
}