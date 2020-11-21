#!/bin/bash

set -e
set -x

cd ..
cd backend
./build-and-copy.sh
cd ..
cd frontend
./build-and-copy.sh
