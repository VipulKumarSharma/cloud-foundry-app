
# Cloud Foundry App

## Description

This Project shows the list of Users which are stored in the In-Memory H2 Database.
Using the following endpoints, different operations can be achieved:

 - `/` - This returns the `greeting` string from `application.yml`
 - `/test` - This returns the app name string from `application.properties`
 - `/users` - GET/POST/DELETE the all Users in the H2_DB table.
 - `/users/{id}` - GET/POST/DELETE User in the H2_DB table by id.
 - `/users/name/{name}` - GET/POST/DELETE Users in the H2_DB table by name.
 - `/users/cacheClear` - Clear User Cache
 
Model : 
    `{
        "id": "2",
        "name": "Vipul Sharma",
        "teamName": "Development",
        "salary": 9854555
    }`

## Deployment steps for Cloud Foundry

<b>1. Login to Cloud Foundry CLI</b>

    cf login -a api.run.pivotal.io

<b>2. Push JAR file to Cloud Foundry.</b>

    cf push cloud-foundry-app -p cloud-foundry-app.jar

## Notes :- 

> In case you need to change the buildpacks

    -b https://github.com/cloudfoundry/java-buildpack.git#v3.7

> Update maven wrapper file permission, so that travis can identify maven wrapper command

    git update-index --chmod=+x mvnw

## Docker Commands

Get image from Docker Hub :

    docker pull busybox

Run Docker image :

    docker run busybox

Run Docker image with command :

    docker run busybox ls -latr

List all containers with status :

    docker ps --all

Download (if not available) MongoDB Image, create container & execute the container.
You can create [n] no of copies of images :

    docker run <IMAGE_ID>
    docker run mongo

Launch a previously stopped container :

    docker start <CONTAINER_ID>
    docker start 980b788af773

To enter a docker images and run command interactively :

    docker exec -it 980b788af773 bash

Show all running containers :

    docker ps

Stop the running container using id :

    docker stop 980b788af773

Instantly kill the running container using id :

    docker kill 980b788af773
