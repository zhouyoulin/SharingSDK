# coding:utf-8
from django.shortcuts import render
from django.http import HttpResponse
from . import models
import json

# Create your views here.
def index(request):
    return HttpResponse(u"Hello SharingSDK")


def login(request):
    rect = {'code': 400, 'data': '', 'msg': ''}
    if request.method == 'POST':
        account = request.POST['account']
        password = request.POST['password']
        user = models.User.objects.get(account=account)
        if user == None:
            rect['code'] = 1001
            rect['msg'] = 'account not exist'
        else:
            if user.password == password:
                rect['code'] = 200
                rect['msg'] = 'success'
            else:
                rect['code'] = 1002
                rect['msg'] = 'password error'
    else:
        rect['code'] = 1003
        rect['msg'] = 'http method error'
    rectJson = json.dumps(obj=rect)
    return HttpResponse(rectJson)

def register(request):
    rect = {'code': 400, 'data': '', 'msg': ''}
    if request.method == 'POST':
        account = request.POST['account']
        password = request.POST['password']
        nickName = request.POST['nickName']
        userTup = models.User.objects.get_or_create(account=account,password=password,nickName=nickName)
        if userTup[2]:
            userTup[1].save()
            rect['code'] = 200
            rect['msg'] = 'success'
        else:
            rect['code'] = 1003
            rect['msg'] = 'account is exist'
    else:
        rect['code'] = 1003
        rect['msg'] = 'http method error'
    rectJson = json.dumps(obj=rect)
    return HttpResponse(rectJson)