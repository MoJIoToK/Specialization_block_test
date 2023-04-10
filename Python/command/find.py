from operation import Operation
import logger.logger as lg
class Find:

    def find_note(self):
        id_note = input("Введите id заметки: ")
        lg.log("User entered id of find note")
        print(self.notes_oper.find_note_by_id(int(id_note)))
