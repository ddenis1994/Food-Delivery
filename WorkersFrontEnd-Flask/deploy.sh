#! /bin/sh
gunicorn  app:app -w 5 -b 0.0.0.0:8083