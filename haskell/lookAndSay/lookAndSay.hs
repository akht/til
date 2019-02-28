import Data.List


-- Look and Say 数列
-- 見て言って数列

lookAndSay :: String -> String
lookAndSay xs = concatMap (\s -> show (length s) ++ [head s]) (group xs)


suretsu :: [[Char]]
suretsu = ["1"] ++ (map lookAndSay suretsu)
