from django.db import models

# Create your models here.
class User(models.Model):
    account = models.CharField(max_length=30)
    password = models.CharField(max_length=16)
    nickName = models.CharField(max_length=30)
    createAt = models.DateTimeField(auto_now=False, auto_now_add=True)
    changeTime = models.DateTimeField(auto_now=True, auto_now_add=False)