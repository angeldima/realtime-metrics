#!/bin/bash

set -e
set -x

cd collector
mvn clean install
mvn package
rm -rf ../../dockerstack/backend/*.jar
cp target/*.jar ../../dockerstack/backend/
