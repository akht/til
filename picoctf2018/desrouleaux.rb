require 'json'

File.open("incidents.json") do |file|
    hash = JSON.load(file)
    data = hash['tickets']

    # common src_ip
    freq = data.map {|e| e['src_ip']}.inject(Hash.new(0)) { |h,v| h[v] += 1; h }
    p freq.max_by { |_, v| v }.first

    # number of dst_ip on average
    p data.map {|e| e['dst_ip']}.size / data.map {|e| e['file_hash']}.uniq.size.to_f
end
