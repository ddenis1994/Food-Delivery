FROM python:latest
RUN mkdir /flask
WORKDIR /flask
ADD . /flask/
RUN pip install -r requirements.txt
EXPOSE 5000
CMD ["python", "/flask/app.py"]