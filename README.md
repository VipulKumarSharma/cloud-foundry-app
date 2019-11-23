
# Cloud Foundry App

## Description

This Project shows the list of Users which are stored in the In-Memory H2 Database.
Using the following endpoints, different operations can be achieved:
 - `/` - This returns the `greeting` string from `application.yml`
 - `/test` - This returns the app name string from `application.properties`
 - `/users` - GET/POST the list of Users in the H2_DB table.
 - `/users/{id}` - GET/POST/DELETE User in the H2_DB table.
 - `/users/name/{name}` - GET/POST/DELETE Users in the H2_DB table.
 
 Model : `{
        "name": "Vipul",
        "teamName": "Development",
        "salary": 9854555
        }`

## Deployment steps for Cloud Foundry

<b>1. Login to Cloud Foundry CLI</b>

    cf login -a api.run.pivotal.io

<b>2. Push JAR file to Cloud Foundry.</b>

    cf push cloud-foundry-app -p cloud-foundry-app.jar

<b>Note : In case you need to change the buildpacks</b>

    -b https://github.com/cloudfoundry/java-buildpack.git#v3.7
