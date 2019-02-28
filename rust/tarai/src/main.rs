fn main() {
    println!("{}", tarai(36, 18, 0))
}

fn tarai(x: i32, y: i32, z: i32) -> i32 {
    if x <= y {
        z
    } else {
        tarai(tarai(x - 1, y, z), tarai(y - 1, z, x), tarai(z - 1, x, y))
    }
}