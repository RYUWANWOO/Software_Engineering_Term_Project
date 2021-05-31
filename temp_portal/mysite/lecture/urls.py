from django.urls import path
from . import views

app_name = 'lecture'

urlpatterns = [
    path('', views.show, name='show'),
    path('<int:lecture_id>/', views.detail, name='detail'),
    path('create/', views.lecture_create, name='lecture_create'),
    path('delete/<int:lecture_id>/', views.lecture_delete, name='lecture_delete'),
]