main :: IO ()
main = interact $ show . f . map read . words

f (n:l) = sum l - n


--5
--7 46 11 20 11