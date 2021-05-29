from django.contrib import admin
from . import models
# Register your models here.

@admin.register(models.User)
class CustomUserAdmin(admin.ModelAdmin) :
    list_display=('username','first_name','last_name',"job" ,'is_staff')
    list_filter=("job",)