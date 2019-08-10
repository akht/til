n = gets.to_i
ss = n.times.map { gets.strip }

# アナグラムである = 文字列中の文字をソートした結果が一致する

# すべてのsをソートして、同じものが何回登場するかで組み合わせの数がわかるので
# それらの総和が答え

def comb(n, r)
    if r == 0
        return 1
    end
    
    (n - r + 1) * comb(n, r - 1) / r
end

puts ss.map {|s| s.chars.sort.join}
        .each_with_object(Hash.new(0)) {|s, hash| hash[s] += 1}.values
        .map {|n| comb(n, 2)}.inject(:+)