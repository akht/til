import Data.Char

main :: IO ()
main = do
    n <- getLine
    let sn = sum $ map digitToInt n
    print $ if read n `mod` sn == 0 then "Yes" else "No"