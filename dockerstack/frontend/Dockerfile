FROM httpd:alpine

MAINTAINER Angelo <email@somedomain.com>

RUN rm -r /usr/local/apache2/htdocs/*
COPY ./dist/metric-dashboard/* /usr/local/apache2/htdocs/
