from django.contrib import admin

# Register your models here.
from .models import Notice

class QuestionAdmin(admin.ModelAdmin):
    search_fields = ['subject']


admin.site.register(Notice,QuestionAdmin)