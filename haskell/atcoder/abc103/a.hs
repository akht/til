main :: IO ()
main = print . solve . map read . words =<< getLine

solve :: [Int] -> Int
solve = (-) <$> maximum <*> minimum