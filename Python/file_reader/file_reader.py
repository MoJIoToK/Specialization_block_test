import csv
from datetime import datetime
import note
import logger.logger as lg
    
DATE_FORMAT = '%Y-%m-%d %H:%M:%S'

class FileReader:

    def __init__(self, file_name):
        self.file_name = file_name
        self.notes = []

    def load_notes(self):
        try:
            with open(self.file_name, 'r', encoding='utf-8') as file:
                reader = csv.reader(file, delimiter=';')
                for row in reader:
                    if len(row) > 0:
                        notes = note.Note(int(row[0]), row[1], row[2], datetime.strptime(row[3], DATE_FORMAT),
                                    datetime.strptime(row[4], DATE_FORMAT))
                        self.notes.append(notes)
                lg.log("Data Base is loaded")
        except FileNotFoundError:
            print(f"{self.file_name} файл не найден. Добавьте первую заметку.")

    def save_notes(self):
        with open(self.file_name, 'w', newline="", encoding='utf-8') as file:
            file.truncate()
            writer = csv.writer(file, delimiter=';')
            for note in self.notes:
                writer.writerow(
                    [note.id, note.title, note.body, note.created_time.strftime(DATE_FORMAT),
                     note.updated_time.strftime(DATE_FORMAT)])
            lg.log("Note is saved in Data Base")