from operation import Operation
import logger.logger as lg

class Create:

    def create_note(self):
        title = input("Введите название заметки: ")
        lg.log("User entered title of note")
        body = input("Введите текст заметки: ")
        lg.log("User entered body of note")
        self.notes_oper.add_note(title, body)
