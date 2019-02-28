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

#[derive(Debug)]
struct Point {
    pub y: i64,
    pub x: i64,
    pub cost: i64,
}

impl Point {
    pub fn new(y: i64, x: i64, cost: i64) -> Point {
        Point { y: y, x: x, cost: cost }
    }
}

use std::collections::VecDeque;

fn main() {
    input! {
        h: i64,
        w: i64,
        t: i64,
        grid: [chars; h],
    }

    let mut sy = 0;
    let mut sx = 0;
    let mut gy = 0;
    let mut gx = 0;

    for y in 0..h {
        for x in 0..w {
            if grid[y as usize][x as usize] == 'S' {
                sy = y;
                sx = x;
            } else if grid[y as usize][x as usize] == 'G' {
                gy = y;
                gx = x;
            }
        }
    }

    let d: Vec<(i64, i64)> = vec![(1, 0), (-1, 0), (0, 1), (0, -1)];

    let mut ok: i64 = 0;
    let mut ng: i64 = t + 1;
    while (ok - ng).abs() > 1 {
        let mid = (ok + ng) / 2;

        let mut cost_memo = vec![vec![9999999999 as i64; w as usize]; h as usize];

        let mut queue = VecDeque::new();
        queue.push_back(Point::new(sy, sx, 0));

        while !queue.is_empty() {
            let now = queue.pop_front().unwrap();

            for &(dy, dx) in d.iter() {
                let next_y = now.y + dy;
                let next_x = now.x + dx;

                if !(0 <= next_y && next_y < h && 0 <= next_x && next_x < w) {
                    continue;
                }

                let next_cost = if grid[next_y as usize][next_x as usize] == '#' {
                    now.cost + mid
                } else {
                    now.cost + 1
                };

                if next_cost < cost_memo[next_y as usize][next_x as usize] {
                    cost_memo[next_y as usize][next_x as usize] = next_cost;
                    queue.push_back(Point::new(next_y, next_x, next_cost));
                }
            }
        }

        if cost_memo[gy as usize][gx as usize] <= t {
            ok = mid;
        } else {
            ng = mid;
        }
    }

    println!("{}", ok);
}
