from operation import Operation
import logger.logger as lg

class Edit:

    def edit_note(self):
        id_note = input("Введите id заметки: ")
        lg.log("User entered id of edit note")
        title = input("Введите название заметки: ")
        lg.log("User entered title of edit note")
        body = input("Введите текст заметки: ")
        lg.log("User entered body of edit note")
        self.notes_oper.edit_note_by_id(int(id_note), title, body)
