# Generated by Django 3.1.3 on 2021-05-30 23:23

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('lecture', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='lecture',
            name='upload',
            field=models.FileField(null=True, upload_to=''),
        ),
    ]
