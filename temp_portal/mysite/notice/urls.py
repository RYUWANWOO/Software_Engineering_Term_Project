from django.urls import path

from . import views

app_name = 'notice'

urlpatterns = [
    path('', views.notice, name='notice'),
    path('<int:question_id>/', views.detail, name='detail'),
    path('question/create/',views.question_create, name='question_create'),
]