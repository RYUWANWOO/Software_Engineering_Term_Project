from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404 ,redirect
# Create your views here.
from .models import Notice
from django.utils import timezone
from .forms import NoticeForm


def notice(request):

    notice_list = Notice.objects.order_by('-create_date')
    context = {'notice_list': notice_list}

    return render(request, 'notice/notice_list.html', context)


def detail(request,notice_id):
    notice = get_object_or_404(Notice, pk=notice_id)
    context = {'notice': notice}
    return render(request,'notice/notice_detail.html',context)


def notice_create(request):
    if request.method == 'POST':
        form = NoticeForm(request.POST)
        if form.is_valid():
            notice = form.save(commit=False)
            notice.create_date = timezone.now()
            notice.save()
            return redirect('notice:notice')
    else:
        form = NoticeForm()
    context = {'form': form}
    return render(request, 'notice/notice_form.html', context)