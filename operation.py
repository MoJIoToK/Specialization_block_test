from note import Note
import file_reader.file_reader as fr
import logger.logger as lg


class Operation:
    def __init__(self, file_name):
        self.file_name = file_name
        self.notes = []
        fr.FileReader.load_notes(self)

    def add_note(self, title, body):
        id = self.get_max_id() + 1
        note = Note(id, title, body)
        self.notes.append(note)
        fr.FileReader.save_notes(self)

    def print_notes(self):
        for note in self.notes:
            print(note)
        lg.log("Notes are printed")

    def find_note_by_id(self, id):
        for note in self.notes:
            if note.id == id:
                return note
        return None

    def edit_note_by_id(self, id, title, body):
        note = self.find_note_by_id(id)
        if note:
            note.update(title, body)
            fr.FileReader.save_notes(self)
            print(f"\nЗаметка #{note.id} обновлена.\n")
            lg.log("Note is updated")
        else:
            print(f"\nЗаметка #{id} не найдена.\n")
            lg.log("Note not found")

    def delete_note_by_id(self, id):
        note = self.find_note_by_id(id)
        if note:
            self.notes.remove(note)
            fr.FileReader.save_notes(self)
            print(f"\nЗаметка #{id} удалена.\n")
            lg.log("Note is removed")
        else:
            print(f"\nЗаметка #{id} не найдена.\n")
            lg.log("Note not found")

    def get_max_id(self):
        if not self.notes:
            return 0
        return max(note.id for note in self.notes)