{-
問題文
黒板に, 3 つの正の整数 A,B,C が書かれています. E869120 君は, 以下の操作を K 回行います.

黒板に書かれている整数のうち 1 つを選び, これを 2 倍した値に書き換える.
さて, K 回の操作を終えた後の, 黒板に書かれる整数の合計としてありうる最大の値はいくつでしょうか？

制約
A,B,C は 1 以上 50 以下の整数
K は 1 以上 10 以下の整数
-}

main :: IO ()
main = do
    [a, b, c] <- map (read :: String -> Int) . words <$> getLine
    [k] <- map (read :: String -> Int) . words <$> getLine
    let m = maximum [a, b, c]
        s = sum [a, b, c]
    print $ s + m * (2^k - 1)