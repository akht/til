macro_rules! input {
    (source = $s:expr, $($r:tt)*) => {
        let mut iter = $s.split_whitespace();
        let mut next = || { iter.next().unwrap() };
        input_inner!{next, $($r)*}
    };
    ($($r:tt)*) => {
        let stdin = std::io::stdin();
        let mut bytes = std::io::Read::bytes(std::io::BufReader::new(stdin.lock()));
        let mut next = move || -> String{
            bytes
                .by_ref()
                .map(|r|r.unwrap() as char)
                .skip_while(|c|c.is_whitespace())
                .take_while(|c|!c.is_whitespace())
                .collect()
        };
        input_inner!{next, $($r)*}
    };
}

macro_rules! input_inner {
    ($next:expr) => {};
    ($next:expr, ) => {};

    ($next:expr, $var:ident : $t:tt $($r:tt)*) => {
        let $var = read_value!($next, $t);
        input_inner!{$next $($r)*}
    };
}

macro_rules! read_value {
    ($next:expr, ( $($t:tt),* )) => {
        ( $(read_value!($next, $t)),* )
    };

    ($next:expr, [ $t:tt ; $len:expr ]) => {
        (0..$len).map(|_| read_value!($next, $t)).collect::<Vec<_>>()
    };

    ($next:expr, chars) => {
        read_value!($next, String).chars().collect::<Vec<char>>()
    };

    ($next:expr, usize1) => {
        read_value!($next, usize) - 1
    };

    ($next:expr, $t:ty) => {
        $next().parse::<$t>().expect("Parse error")
    };
}

use std::collections::VecDeque;

fn main() {
    input!{
        row: usize,
        col: usize,
        sy: usize,
        sx: usize,
        gy: usize,
        gx: usize,
        board: [chars; row],
    }

    let sy = sy - 1;
    let sx = sx - 1;
    let gy = gy - 1;
    let gx = gx - 1;

    // マスの訪問管理
    let mut visited = vec![vec![false; col]; row];

    // dfsのためのキュー
    let mut queue = VecDeque::new();
    let start = Point::new(sy as i32, sx as i32);
    queue.push_back(start);
    visited[sy][sx] = true;

    let move_y: Vec<i32> = vec![-1, 0, 1,  0];
    let move_x: Vec<i32> = vec![ 0, 1, 0, -1];

    while !queue.is_empty() {
        let now = queue.pop_front().unwrap();

        // 上下左右に隣接するマスを取得
        let mut children = Vec::new();
        for i in 0..4 {
            let next_y = now.y + move_y[i];
            let next_x = now.x + move_x[i];

            if !(0 <= next_y && next_y < row as i32 && 0 <= next_x && next_x < col as i32) {
                continue;
            }

            if visited[next_y as usize][next_x as usize] {
                continue;
            }

            if board[next_y as usize][next_x as usize] == '#' {
                continue;
            }

            let mut child = Point::new(next_y, next_x);
            child.dist = now.dist + 1;

            children.push(child);
        }

        for child in children.into_iter() {
            if child.y == gy as i32 && child.x == gx as i32 {
                println!("{}", child.dist);
                return;
            }

            visited[child.y as usize][child.x as usize] = true;
            queue.push_back(child);
        }
    }

}

#[derive(Debug)]
struct Point {
    pub y: i32,
    pub x: i32,
    pub dist: i32,
}

impl Point {
    pub fn new(y: i32, x: i32) -> Point {
        Point { y, x, dist: 0 }
    }
}