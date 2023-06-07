import json

__file_path = 'my_nots.json'

def load_file():
    '''Открывает файл и записывает его содержимое в словарь'''
    with open(__file_path, 'r') as file:
        try:
            data = json.load(file)
        except:
            data = {}
    return data

def save_file(data):
    '''Записывает содержимое словаря в файл'''
    with open(__file_path, 'w') as file:
        json.dump(data, file, indent=3)
