from operation import Operation
from command import create
from command import delete
from command import edit
from command import show
from command import find
from command import exit
import view.menu as menu
import logger.logger as lg

class Console:
    def __init__(self):
        self.notes_oper = Operation("bd\_notes.csv")

    def excute(self):
        flag = True
        while flag:
            menu.Menu.print_menu()
            lg.log("Print menu")
            choice = input("Введите действие (1-6): ")
            
            if choice == "1":
                lg.log("User selected the create note")
                create.Create.create_note(self)
            
            elif choice == "2":
                lg.log("User selected the print notes")
                show.Show.show_notes(self)

            elif choice == "3":
                lg.log("User selected the edit note")
                edit.Edit.edit_note(self)

            elif choice == "4":
                lg.log("User selected the delete note")
                delete.Delete.delete_note(self)

            elif choice == "5":
                lg.log("User selected the find note")
                find.Find.find_note(self)

            elif choice == "6":
                lg.log("User selected the exit in App")
                flag = exit.Exit.exit_note()

            else:
                lg.log("Wrong choice")
                print("\nНеверный выбор. Введите число от 1 до 6.\n")