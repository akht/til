def rpn(exp)
    stack = []

    exp.split(' ').each do |token|
        if /^[+-]?[0-9]*[\.]?[0-9]+$/ =~ token
            stack.push token.to_f
        else
            x = stack.pop
            y = stack.pop
            stack.push y.send(token, x)
        end
    end

    stack.pop
end

exp = gets.strip
ans = rpn(exp);
puts "exp = #{ans}"