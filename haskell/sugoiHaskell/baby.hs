doubleMe :: Num a => a -> a
doubleMe x = x + x

doubleUs :: Num a => a -> a -> a
--doubleUs x y = x * 2 + y * 2
doubleUs x y = doubleMe x + doubleMe y

doubleSmallNumber :: (Ord a, Num a) => a -> a
doubleSmallNumber x = if x > 100 then x else x * 2



-- リスト内包表記を使ったlength関数
length' xs = sum [1| _ <- xs]


-- ありうるすべての組み合わせが生成される
-- [(x, y) | x <- [1,2,3], y <- [10,20,30]]
-- [(1,10),(1,20),(1,30),(2,10),(2,20),(2,30),(3,10),(3,20),(3,30)]


-- 文字列もリストなので、文字列を処理して生成するのにもリスト内包表記が使える

-- 文字列を受け取り、すべての小文字を取り除く関数
removeNonUppercase st = [c | c <- st, c `elem` ['A'..'Z']]

