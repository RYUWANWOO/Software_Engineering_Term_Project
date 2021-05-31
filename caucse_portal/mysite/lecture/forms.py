from django import forms
from lecture.models import Lecture


class LectureForm(forms.ModelForm):
    class Meta:
        model = Lecture
        fields = ['subject', 'upload', 'content']