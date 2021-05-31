from django import forms
from .models import Notice


class NoticeForm(forms.ModelForm):
    class Meta:
        model = Notice
        fields = ['subject','content']
        labels = {
            'subject': '제목',
            'content': '내용',
        }