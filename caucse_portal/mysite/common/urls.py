from django.urls import path
from django.contrib.auth import views as auth_views
from . import views
app_name = 'common'

urlpatterns = [
    path('', auth_views.LoginView.as_view(template_name='common/login.html'), name='login'),
    path('logout/', auth_views.LogoutView.as_view(), name='logout'),
    path('signup/', views.signup, name='signup'),
    path('acc_delete/', views.acc_index, name='acc_index'),
    path('acc_delete/<int:acc_id>/', views.acc_delete, name='acc_delete'),
]