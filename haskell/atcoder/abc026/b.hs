import Data.List
import Control.Monad


-- 高橋君は、丸が大好きです。今日も、原点を中心とした大きさの違う円を N 個書きました。
-- その円の集合に対し、外側から赤白交互に色を塗ったとき、赤く塗られる部分の面積を出力しなさい。

solve :: [Double] -> Double
solve xs = (* pi) $ abs $ sum $ zipWith (*) (cycle [1,-1]) $ map (**2) xs

main :: IO ()
main = do
    n <- readLn
    array <- replicateM n readLn
    -- let array = [15,2,3,7,6,9]
    print . solve $ sort $ array