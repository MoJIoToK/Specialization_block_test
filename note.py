from datetime import datetime


class Note:
    def __init__(self, id_note, title, body, created_time=None, updated_time=None):
        self.id = id_note
        self.title = title
        self.body = body
        self.created_time = created_time or datetime.now()
        self.updated_time = updated_time or datetime.now()

    def __str__(self):
        return f"\nЗаметка #{self.id}: {self.title}\n{self.body}\nСоздана: {self.created_time}\nИсправлена: {self.updated_time}\n"

    def update(self, title, body):
        self.title = title
        self.body = body
        self.updated_time = datetime.now()
