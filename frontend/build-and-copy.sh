#!/bin/bash

set -e
set -x

cd metric-dashboard
npm install
ng build --prod
rm -rf ../../dockerstack/frontend/dist
cp -r dist ../../dockerstack/frontend/dist
