from django.shortcuts import render, get_object_or_404 ,redirect
from .models import Lecture
from django.utils import timezone
from .forms import LectureForm

def show(request):
    """
    lecture 목록 출력
    """
    lecture_list = Lecture.objects.order_by('create_date')
    context = {'lecture_list': lecture_list}

    return render(request, 'lecture/lecture_list.html', context)

def detail(request, lecture_id):
    """
    lecture 내용 출력
    """
    lecture = get_object_or_404(Lecture, pk=lecture_id)
    context = {'lecture': lecture}
    return render(request, 'lecture/lecture_detail.html', context)

def lecture_create(request):
    """
    lecture 등록
    """
    if request.method == 'POST':
        subject = request.POST['subject']
        upload = request.POST['upload']
        content = request.POST['content']
        Lecture.objects.create(subject=subject, upload=upload, content=content, create_date=timezone.now())
        return redirect('lecture:show')
    else:
        form = LectureForm()
    context = {'form': form}
    return render(request, 'lecture/lecture_form.html', context)