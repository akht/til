use std::env;
use std::process;
use std::fs::File;
use std::io::BufReader;
use std::io::BufRead;
use std::io::Stdin;

fn main() {
    let args: Vec<String> = env::args().skip(1).collect();

    if args.len() < 1 {
        // 標準入力から読み込む
        let stdin: Stdin = std::io::stdin();
        let mut buf_file = BufReader::new(stdin);
        do_cat(&mut buf_file);
    } else {
        // 引数で指定されたファイルを読み込む
        for filename in &args {
            match File::open(filename) {
                Ok(file) => {
                    let mut buf_file = BufReader::new(file);
                    do_cat(&mut buf_file);
                }
                Err(e) => {
                    eprintln!("Application error: {}", e);
                    process::exit(1);
                }
            }
        }
    }
}

fn do_cat(stream: &mut BufRead) -> () {
    let mut buffer = String::new();
    loop {
        match stream.read_line(&mut buffer) {
            Ok(0) => break, // EOF
            Ok(_) => {
                print!("{}", buffer);
                buffer.clear();
            }
            Err(e) => {
                eprintln!("Application error: {}", e);
                process::exit(1);
            }
        }
    }

    ()
}