currencies = {'japan'=>'yen', 'us'=>'dollar', 'indiea'=>'rupee'}
currencies['italy'] = 'euro'

currencies.each do |key, value|
  puts "#{key}:#{value}"
end

currencies.each do |key_value|
  puts "#{key_value} key:#{key_value[0]} value:#{key_value[1]}"
end

a = {'x'=>1, 'y'=>2, 'z'=>3}
b = {'x'=>1, 'y'=>2, 'z'=>3}
a == b #=> true

c = {'z'=>3, 'y'=>2, 'x'=>1}
a == c #=> true

d = {'x'=>10, 'y'=>2, 'z'=>3}
a == d #=> false

currencies.delete('japan') #=> yen

currencies.delete('brazil') {|key| "Not found: #{key}"} #=> Not found: brazil


s = :apple
p s.class

# シンボルは内部では整数として管理される

:apple == :apple

# 同じシンボルであれば同じオブジェクトである
p :apple.object_id
p :apple.object_id

# シンボルはイミュータブル
symbol = :apple
# symbol.upcase! #=> NoMethodError

# 文字列をハッシュのキーにする
currencies = {'japan' => 'yen', 'us' => 'dollar', 'india' => 'rupee'}
currencies['japan'] #=> yen

# シンボルをハッシュのキーにする(キーを指定して値を取り出すときに文字列より高速)
currencies = {:japan => 'yen', :us => 'dollar', :india => 'rupee'}
currencies[:japan] #=> yen

# シンボルをキーにしてハッシュを作るときはこう書ける
currencies = {japan:'yen', us:'dallar', india:'rupee'}
currencies[:us]

# キーも値もシンボルのとき
{janap: :yen, us: :dollar, india: :rupee}

def buy_burger(menu, drink, potato)
  if drink
    # ドリンク購入
  end

  if potato
    # ポテト購入
  end
end

buy_burger('cheese', true, false)
buy_burger('fish', false, true)


# キーワード引数
def buy_burger(menu, drink: true, potato: true)
  if drink
    # ドリンク購入
  end

  if potato
    # ポテト購入
  end
end

buy_burger('cheese', drink: true, potato: false)
buy_burger('fish', drink: false, potato: true)
buy_burger('cheese', potato: false, drink: true)
buy_burger('cheese')

# キーワド引数に一致するハッシュ（キーはシンボル）を引数として渡せる
params = {drink: true, potato: false}
buy_burger('cheese', params)
