## About the Dealership Application:

An API for a car dealership that allows customers to (search/add/purchase)cars.
It is built with Java and Spring Framework. 
Main API URL http://localhost:8080/api/cars

## Features
* This API provides HTTP endpoint's and tools for the following:

![api](https://user-images.githubusercontent.com/17921423/236629283-a9bdf632-cca6-42fb-b0a9-9dc2f8c5fff4.png)


* Find a unique car by id: `GET/api/cars/{id}`

![byID](https://user-images.githubusercontent.com/17921423/236629113-a8275747-de53-46d7-a482-361c6b8a984d.png)

* Find all cars by model: `GET/api/cars`

![byModel](https://user-images.githubusercontent.com/17921423/236629245-bf46e5a8-6f43-4caf-a283-33ab83c58144.png)


# Steps to Setup
1. Clone the application

git clone https://github.com/Miller1995/DealershipApp.git

2. Create MySQL database

create database "dealership"

3. Change MySQL username and password

open src/main/resources/application.properties 
change spring.datasource.username and spring.datasource.password

4. Run the app using maven

mvn spring-boot:run
