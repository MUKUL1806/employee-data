# 💼 Spring Boot REST API Project

A full-stack backend project built with **Spring Boot** that exposes RESTful APIs with full CRUD functionality. The app is containerized using Docker, deployed on **Render**, and uses a **MySQL** database hosted on **Aiven**.

## 🚀 Features

- Full CRUD operations
- RESTful API design
- Dockerized application
- MySQL on Aiven
- Deployed on Render

## 🔧 Tech Stack

- Java 21
- Spring Boot
- MySQL (Aiven)
- Docker
- Render
- JPA 

## 📦 Deployment

- 🔗 **Render**: (https://dashboard.render.com/web/srv-cvuhkieuk2gs738cp1og)
- 🗄️ **Aiven MySQL**: [Hosted securely on Aiven](https://console.aiven.io/account/a527f1867f52/project/employee-data/services)
- Docker https://hub.docker.com/repository/docker/danik1234/employee-deployment/image-management




All Curls
GET ALL Employee

curl --location 'https://employee-deployment.onrender.com/api/v1/employees'


Create Employee

curl --location 'https://employee-deployment.onrender.com/api/v1/employees' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName" : ",mukul",
    "lastName" : "jain",
    "emailId" : "mukul@gmail.com"
}'


Update Employee
curl --location --request PUT 'https://employee-deployment.onrender.com/api/v1/employees/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"umesh",
    "lastName" : "sharma",
    "emailId" : "umesh@gmail.com"
}'


Delete Employee
curl --location --request PUT 'https://employee-deployment.onrender.com/api/v1/employees/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"umesh",
    "lastName" : "sharma",
    "emailId" : "umesh@gmail.com"
}'
