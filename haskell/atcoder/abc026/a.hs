-- 正の偶数 A が与えられる。
-- x+y=A となる正の整数 x, y のうち、 x×y が最大となるものを選び、その値を出力しなさい。

main :: IO ()
main = do
    a <- readLn
    print $ (a `div` 2) ^ 2