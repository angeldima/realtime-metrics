#!/bin/bash

set -e
set -x

docker build -t realtime-metrics/backend-container ./backend
docker build -t realtime-metrics/frontend-container ./frontend

docker run -it -d -p 8080:8080 realtime-metrics/backend-container 
docker run -it -d -p 80:80 realtime-metrics/frontend-container



