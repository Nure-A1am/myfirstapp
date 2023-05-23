# Simple Spring Boot Rest API Employee Managment
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen.svg)
![Mysql](https://img.shields.io/badge/Mysql-8.2.4-blue.svg)
![JDK](https://img.shields.io/badge/Java-17-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-4.0.0-yellowgreen.svg)

 <!--- ![license](https://img.shields.io/badge/license-MPL--2.0-blue.svg) --->


### API Usages

|Method | Endpoint| Usages |
| -------- | -------- | -------- |
| `POST`   | api/v1/employee/register | Register New Employee |
| `PUT`    | api/v1/employee/update/EMPLOYEE_ID_HERE | Update Existing Employee Info |
| `DELETE` | api/v1/employee/EMPLOYEE_ID_HERE | Delete Employee |
| `GET`    | api/v1/employee/EMPLOYEE_ID_HERE | Get Specific Employee Info |
| `GET`    | api/v1/employee/ | Get Specific All Info |




Register User using `POST` request

Json Body:

```json
{
        "firstName": "Mr.",
        "lastName": "Bean",
        "emailId": "mrbean@gmail.com",
        "designation": "HR Head",
        "salary": "1200000"
}
```

Update Employee using `PUT` request

Json Body:

```json
{
        "firstName": "Mr.",
        "lastName": "Bean",
        "emailId": "mrbean@gmail.com",
        "designation": "CEO",
        "salary": "1200000"
}
```