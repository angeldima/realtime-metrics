# realtime-metrics
Required:
* jdk11
* maven
* At least Angular CLI: 9.1.0

## How to start the project
There are three possible ways to start this project

### Start project 01
The simplest way if you have Docker installed

```sh
$ cd dockerstack
$ ./stack-start.sh
```
Reach the application at http://localhost \
This works because in the dockerstack folder are already included all the files to deploy

### Start project 02
The best way to start project if you have Docker installed and need to build a new version of the application

```sh
$ cd dockerstack
$ ./stack-build.sh
$ ./stack-start.sh
```
Reach the application at http://localhost

### Start project 03
The best way to start project if you don't have Docker installed

```sh
$ cd backend/collector/
$ mvn clean spring-boot:run
$ cd frontend/metric-dashboard/
$ npm install
$ ng serve
```
Reach the application at http://localhost:4200
