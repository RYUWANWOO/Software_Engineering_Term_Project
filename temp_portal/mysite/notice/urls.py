from django.urls import path

from . import views

app_name = 'notice'

urlpatterns = [
    path('', views.notice, name='notice'),
    path('<int:notice_id>/', views.detail, name='detail'),
    path('notice/create/', views.notice_create, name='notice_create'),
]