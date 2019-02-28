import Data.List
import System.Random

-- コインを100回投げたうち、表もしくは裏が10回出る確率をモンテカルロ法で計算する

-- 乱数を生成
coinSeq :: (RandomGen g) => g -> [Bool]
coinSeq = randoms


-- seq(無限リスト)を、先頭からn個の要素ずつのリストにまとめて返す
splitN :: Int -> [a] -> [[a]]
splitN n seq = take n seq : splitN n (drop n seq)


-- モンテカルロ法で計算を実行する
monteCarlo :: Int -> [Bool] -> Double
monteCarlo try_count seq = (fromIntegral success_count / fromIntegral try_count) * 100.0
  where
    seq_n = take try_count (splitN 100 seq)
    success_count = length . filter id $ map (coinToss 10) seq_n


-- [Bool]の中に連続したlen個のTrueまたはFalseがあるかどうかを返す
coinToss :: Int -> [Bool] -> Bool
coinToss _ [] = False
coinToss len seq = hasContiguousElems len seq

-- [a]のなかに連続した要素がlen個以上あるかどうか
hasContiguousElems :: (Eq a) => Int -> [a] -> Bool
hasContiguousElems len seq = any (>= len) (map length (group seq))



main = do
  gen <- getStdGen
  let s = coinSeq gen
  mapM_ (\n -> putStrLn (show n ++ "\t : " ++ show (monteCarlo n s) ++ "%") )
    [100, 1000, 10000, 100000]
