
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
 - `jdbc:h2:mem:testdb` - H2 JDBC URL
 
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

## Github Package Registry

Add Dockerfile in project's root directory
    
    FROM openjdk:8-jdk-alpine
    COPY target/cloud-foundry-app.jar cloud-foundry-app.jar
    EXPOSE 8080
    ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "cloud-foundry-app.jar"]
    
Add code & build the project

    mvn clean install
    
Build docker image (with name mentioned in Dockerfile) & check the same

    docker build . -t cloud-foundry-app:v1
    docker images
    
Add Tag to docker image

    docker tag cloud-foundry-app:v1 docker.pkg.github.com/vipulkumarsharma/cloud-foundry-app/cloud-foundry-app:v1

Login to github docker repo (using Github Token keys)</b>

    docker login docker.pkg.github.com -u VipulKumarSharma -p <GH_KEY>
    
Push docker image to github package registry</b>

    docker push docker.pkg.github.com/vipulkumarsharma/cloud-foundry-app/cloud-foundry-app:v1

<i>Note : Use account name in lowercase only (in URL & tagging)</i>

Run Docker image

    docker run cloud-foundry-app:v1 -p 8080:8080
    
URL for locally running app in container
    
    http://172.17.0.2:8080


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

To enter a image & execute some commands we have few methods

- Start the container & run command interactively
    
    > docker start 980b788af773
    
    > docker exec -it 980b788af773 bash
    
- Directly run docker image with command [ It is not an advised approach, which can override the default behaviour of container initialization & might cause problems ]

    > docker run -it mongo bash
    