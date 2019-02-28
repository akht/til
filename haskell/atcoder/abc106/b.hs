main :: IO ()
main = print =<< solve <$> readLn

solve :: Int -> Int
solve n = length [ x | x <- [1,3..n], length [ y | y <- [1..n], x `mod` y == 0] == 8]