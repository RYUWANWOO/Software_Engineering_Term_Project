from django.db import models

class Lecture(models.Model):
    subject = models.CharField(max_length=200)
    upload = models.FileField(upload_to='uploads/')
    content = models.TextField()
    create_date = models.DateTimeField()

    def __str__(self):
        return self.subject