fn main() {
    let mut vec = Vec::new();
    vec.push('a');
    vec.push('b');
    vec.push('c');

    let len = vec.len();

    // {a, b, c}の部分集合を列挙

    for bit in 0..(1 << len) {
        let mut s = String::new();
        for i in 0..len {
            if bit & (1 << i) != 0 {
                s += &vec[i].to_string();
            }
        }
        println!("{}", s);
    }
}
