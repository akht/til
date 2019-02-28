-- abcdと与えたら、各文字を大文字・小文字にした全パターンを返すような関数を作ってみる
import Data.Char

getAll :: String -> [String]
getAll str = sequence [ [toUpper c, toLower c] | c <- str]
