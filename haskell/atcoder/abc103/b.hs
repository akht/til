main :: IO ()
main = do
    s <- getLine
    t <- getLine
    putStrLn $ solve s t

solve :: String -> String -> String
solve s t
    | t `elem` rotations s = "Yes"
    | otherwise            = "No"


rotations :: String -> [String]
rotations s = rotation [s] $ length s - 1

rotation :: [String] -> Int -> [String]
rotation xs 0 = xs
rotation xs n = rotation ((rotate $ head xs) : xs) $ n-1

rotate :: String -> String
rotate xs = [last xs] ++ init xs


