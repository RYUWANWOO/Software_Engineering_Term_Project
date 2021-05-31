from django.contrib import admin

# Register your models here.
from .models import Lecture

class LectureAdmin(admin.ModelAdmin):
    search_fields = ['subject']


admin.site.register(Lecture,LectureAdmin)