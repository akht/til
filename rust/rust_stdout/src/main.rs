use std::io::{stdout, Write, BufWriter};

fn main() {
    
    // println! (遅い 12.362秒)
    // for _ in 0..10_000_000 {
    //     println!("yes");
    // }

    // ロックレス (まだ遅い 10.547秒)
    // let out = stdout();
    // let mut out = out.lock();
    // for _ in 0..10_000_000 {
    //     writeln!(out, "yes").unwrap();
    // }

    // 改行なし (結構速くなった 0.466秒)
    // let out = stdout();
    // let mut out = out.lock();
    // for _ in 0..10_000_000 {
    //     write!(out, "yes").unwrap();
    // }

    // バッファリング (速い 0.443秒)
    // let out = stdout();
    // let mut out = BufWriter::new(out.lock());
    // for _ in 0..10_000_000 {
    //     writeln!(out, "yes").unwrap();
    // }

    // さらなる高みへ (0.012秒!)
    // 1行yesを描くごとに毎度write!を呼ぶと遅いのである程度まとめてwrite!を呼ぶ
    let out = stdout();
    let mut out = BufWriter::new(out.lock());
    let yes = {
        let mut s = String::with_capacity(4096);
        for _ in 0..2048 {
            s += "yes\n";
        }
        s
    };
    let rest = {
        let mut s = String::with_capacity(4096);
        for _ in 0..(10_000_000 % 2048) {
            s += "yes\n";
        }
        s
    };

    for _ in 0..(10_000_000 / 2048) {
        out.write_all(yes.as_bytes()).unwrap();
    }
    out.write_all(rest.as_bytes()).unwrap();


    // お手軽（バッファリング+write） 0.131秒!
    // let out = stdout();
    // let mut out = BufWriter::new(out.lock());
    // for _ in 0..10_000_000 {
    //     out.write(b"yes\n").unwrap();
    // }
}
