# Employee Managment System With Role Based Authentication
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen.svg)
![Mysql](https://img.shields.io/badge/Mysql-8.2.4-blue.svg)
![JDK](https://img.shields.io/badge/Java-17-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-4.0.0-yellowgreen.svg)

 <!--- ![license](https://img.shields.io/badge/license-MPL--2.0-blue.svg) --->
 
 
### Project Usages

Just connect with your MySql server. You don't need to create any database or table, database and tables will be automatically created when you run this Application.

#### application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME?createDatabaseIfNotExist=true
spring.datasource.username=YOUR_MYSQL_DATABASE_USERNAME
spring.datasource.password=YOUR_MYSQL_DATABASE_PASSWORD

#jpa vendor adapter configuration
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto = update
```


### Web Page Address

| Link                                                   | Usages                |
|--------------------------------------------------------|-----------------------|
| `http://localhost:8080/employee/new`                   | Register New Employee |
| `http://localhost:8080/employee/list`                  | List Of All Employee  |
| `http://localhost:8080/employee/edit/EMPLOYEE_ID_HERE` | Update Employee Info  |
| `http://localhost:8080/login`                          | Login Page            |


### Default Users Info

| Username        | Password | Role            | Privilege           |
|-----------------|----------|-----------------|---------------------|
| sales@email.com | pw789    | sales_executive | No Privilege        |
| it@email.com    | pw456    | it_support      | Add, Update, Delete |
| hr@email.com    | pw123    | hr_manager      | Add, Update, Delete |

### Screenshots:

#### Index / Welcome Page
<p align="center">
  <img src="https://github.com/Nure-A1am/myfirstapp/blob/main/src/main/resources/screenshots/ss1.PNG"
    alt="Index Page" />
</p>

#### Login Page
<p align="center">
  <img src="https://github.com/Nure-A1am/myfirstapp/blob/main/src/main/resources/screenshots/ss2.PNG"
    alt="Login Page" />
</p>

#### Employee List Page
<p align="center">
  <img src="https://github.com/Nure-A1am/myfirstapp/blob/main/src/main/resources/screenshots/ss3.PNG"
    alt="Employee List Page" />
</p>

#### Employee Info Update Page
<p align="center">
  <img src="https://github.com/Nure-A1am/myfirstapp/blob/main/src/main/resources/screenshots/ss4.PNG"
    alt="Employee Info Update Page" />
</p>

#### Access Denided Page
<p align="center">
  <img src="https://github.com/Nure-A1am/myfirstapp/blob/main/src/main/resources/screenshots/ss5.PNG"
    alt="Access Denided Page" />
</p>


[//]: # (### API Usages)

[//]: # ()
[//]: # (|Method | Endpoint| Usages |)

[//]: # (| -------- | -------- | -------- |)

[//]: # (| ![]&#40;https://img.shields.io/badge/-POST-blue.svg&#41;   | `api/v1/employee/register` | Register New Employee |)

[//]: # (| ![]&#40;https://img.shields.io/badge/-PUT-9cf.svg&#41;     | `api/v1/employee/update/EMPLOYEE_ID_HERE` | Update Existing Employee Info |)

[//]: # (| ![]&#40;https://img.shields.io/badge/-DELETE-red.svg&#41;  | `api/v1/employee/EMPLOYEE_ID_HERE` | Delete Employee |)

[//]: # (| ![]&#40;https://img.shields.io/badge/-GET-brightgreen&#41; | `api/v1/employee/EMPLOYEE_ID_HERE` | Get Specific Employee Info |)

[//]: # (| ![]&#40;https://img.shields.io/badge/-GET-brightgreen&#41; | `api/v1/employee` | Get All Employee Info |)

[//]: # ()
[//]: # ()
[//]: # ()
[//]: # ()
[//]: # (Register Employee using ![]&#40;https://img.shields.io/badge/-POST-blue.svg&#41; request)

[//]: # ()
[//]: # (Json Body:)

[//]: # ()
[//]: # (```json)

[//]: # ({)

[//]: # (        "firstName": "Mr.",)

[//]: # (        "lastName": "Bean",)

[//]: # (        "emailId": "mrbean@gmail.com",)

[//]: # (        "designation": "HR Head",)

[//]: # (        "salary": "30000")

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (Update Employee using ![]&#40;https://img.shields.io/badge/-PUT-9cf.svg&#41; request)

[//]: # ()
[//]: # (Json Body:)

[//]: # ()
[//]: # (```json)

[//]: # ({)

[//]: # (        "firstName": "Mr.",)

[//]: # (        "lastName": "Bean",)

[//]: # (        "emailId": "mrbean@gmail.com",)

[//]: # (        "designation": "CEO",)

[//]: # (        "salary": "1200000")

[//]: # (})

[//]: # (```)
