from datetime import datetime


class ViewNots():
    '''Класс для вывода и ввода информации от пользователя
    при работе с телефонной книгой'''

    staticmethod
    def menu() -> int:
        '''Печатает меню и запрашивает от пользователя выбранного пункта меню'''
        print('''\nГлавное меню:
            1. Показать заметки
            2. Добавить заметку
            3. Удалить заметку
            4. Найти заметку
            5. Изменить контакт
            6. Выход\n''')
        while True:
            try:
                num = int(input('введите номер операции: '))
                print()
                if 0 < num < 7:
                    return num
                else:
                    print('\nОшибка! Введите число от 1 до 6\n')
            except:
                print('\nИспользуй цыфры\n')

    staticmethod
    def print_nots(data):
        '''Выводит весь список заметок'''
        if data:
            for i, note in enumerate(data['Nots'], 1):
                print(f'{i}. {note.get("date"):<10}'
                    f'{note.get("time"):<10}'
                    f'{note.get("header"):<20}'
                    f'{note.get("body")}')
            print()
        else:
            print('Заметок нет')

    staticmethod
    def add_note() -> dict:
        '''Запрос данных для новой заметки'''
        date = datetime.now().strftime('%d.%m.%y')   
        time = datetime.now().strftime('%H:%M')
        header = input('Введите заголовок: ')
        body = input('Введите заметку: ')
        new_note = {"date": date,
                    "time": time,
                    "header": header,
                    "body": body}
        return new_note

    staticmethod
    def note_selection(data):
        '''Запрашивает номер удаляемой/изменяемой заметки'''
        ViewNots.print_nots(data)
        try:
            num = int(input('введите порядковый номер заметки: '))
            file = data['Nots']
            if 0 < num <= len(file):
                return num - 1
            else:
                print('Неверный номен')
        except:
            print('\nИспользуй цыфры\n')
        return None


    staticmethod
    def confirmation_of_action(data, num, massege):
        while True:
            file = data['Nots']
            print(f'\nВы точно хотите {massege} данную запись?\n'
                f'{file[num].get("date"):<10}'
                f'{file[num].get("time"):<10}'
                f'{file[num].get("header"):<20}'
                f'{file[num].get("body")}')
            choise = input('Введите y/n: ').strip()
            if choise == 'y':
                return True
            elif choise == 'n':
                break
            print("неверный ввод")
        return False


    staticmethod
    def search_note(data):
        '''Запрашивает дату для поиска заметки'''
        date = input('введите дату для поиска (в формате дд.мм.гг): ')
        print()
        if ViewNots.isdate(date):
            ViewNots.sort_nots(data, date)
        else:
            print('\nНеверный ввод!\n')

    staticmethod
    def sort_nots(data:dict, date:str):
        '''Вывод отсортированого по дате списка заметок'''
        flag = False
        for i, note in enumerate(data['Nots'], 1):
            if note.get('date') == date:
                print(f'{i}. {note.get("date"):<10}'
                    f'{note.get("time"):<10}'
                    f'{note.get("header"):<20}'
                    f'{note.get("body")}')
                flag = True
        print()
        if not flag:
            print(f'Заметок в указаный день({date}) не обнаружено')


    staticmethod
    def isdate(date: str) -> bool:
        '''Проверяет является ли строка датой'''
        date = date.split(".")
        if len(date) == 3:
            for i in date:
                if not i.isdigit() or len(i) != 2:
                    return False
        else:
            return False
        return True

