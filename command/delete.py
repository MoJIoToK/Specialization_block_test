from operation import Operation
import logger.logger as lg

class Delete:

    def delete_note(self):
        id_note = input("Введите id заметки: ")
        lg.log("User entered id of delete note")
        self.notes_oper.delete_note_by_id(int(id_note))
