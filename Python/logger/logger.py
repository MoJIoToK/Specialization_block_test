from datetime import datetime as dt
from time import time

def log(data):
    time = dt.now().strftime('%d.%m.%Y %H:%M')
    with open('logger\log.csv', 'a') as file:
        file.write('{} - {}\n'
                    .format(time, data))