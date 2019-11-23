

# Cloud Foundry App

## Description

This Project shows the list of Users which are stored in the In-Memory H2 Database.
Using the following endpoints, different operations can be achieved:
 - `/helloworld` - This returns the `greeting` string from `application.yml`
 - `/helloworld/name` - This returns the value of config `config.app.name` from `application.properties`
 - `/users` - This returns the list of Users in the Users table which is created in H2
 - `/users/name/{name}` - This returns the details of the Users passed in URL
 - `/users/load` - Add new users using the Users model. 
    eg. `{
        "name": "Ajay",
        "teamName": "Development",
        "salary": 100
        }`

## Deployment steps for Cloud Foundry

<b>1. Login to Cloud Foundry CLI</b>

    cf login -a api.run.pivotal.io

<b>2. Push JAR file to Cloud Foundry.</b>

    cf push cloud-foundry -p cloud-foundry.jar

<b>3. In case you need to change the buildpacks</b>

    -b https://github.com/cloudfoundry/java-buildpack.git#v3.7