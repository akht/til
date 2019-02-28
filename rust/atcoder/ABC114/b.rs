use std::io;
use std::cmp::min;

fn main() {
    let stdin = io::stdin();
    let mut buf = String::new();
    stdin.read_line(&mut buf).ok();
    let bytes = buf.as_bytes();

    let mut ans = 10000;
    for i in 0..bytes.len() - 3 {
        let now =
              (bytes[i] as i32 - b'0' as i32) * 100
            + (bytes[i+1] as i32 - b'0' as i32) * 10
            + (bytes[i+2] as i32 - b'0' as i32);
        
        ans = min(ans, (now - 753).abs());
    }
    println!("{}", ans);
}