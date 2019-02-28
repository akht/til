use std::io;
use std::str::FromStr;

fn main() {
    let stdin = io::stdin();
    let mut buf = String::new();
    stdin.read_line(&mut buf).ok();
    let mut it = buf.split_whitespace().map(|n| usize::from_str(n).unwrap());
    let n = it.next().unwrap();

    println!("{}", count(n, 0));
}

fn count(n: usize, x: usize) -> usize {
    if n < x {
        return 0;
    }

    let mut ret = 1;
    for c in "357".chars() {
        if !x.to_string().contains(c) {
            ret = 0;
            break;
        }
    }
    
    for c in "357".chars() {
        let next = x * 10 + (c as usize - '0' as usize);
        ret += count(n, next);
    }
    
    ret
}