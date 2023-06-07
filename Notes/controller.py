import SavingLoading as SL
from view import ViewNots as view

def start():
    data = SL.load_file()
    while True:
        choise = view.menu()
        match choise:
            case 1:
                view.print_nots(data)
            case 2:
                data['Nots'].append(view.add_note())
                SL.save_file(data)
            case 3:
                num = view.note_selection(data)
                if num and view.confirmation_of_action(data, num, "удалить"):
                    del data['Nots'][num]
                    SL.save_file(data)
            case 4:
                view.search_note(data)
            case 5:
                num = view.note_selection(data)
                if num:
                    new_note = view.add_note()
                    if view.confirmation_of_action(data, num, "изменить"):
                        data['Nots'].pop(num)
                        data['Nots'].append(new_note)
            case 6:
                break





