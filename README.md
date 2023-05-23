# Spring Boot Rest API User Authentication

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen.svg)
![Mysql](https://img.shields.io/badge/Mysql-8.2.4-blue.svg)
![JDK](https://img.shields.io/badge/Java-17-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-4.0.0-yellowgreen.svg)

 <!--- ![license](https://img.shields.io/badge/license-MPL--2.0-blue.svg) --->


### API Usages

|Method | Endpoint|
| -------- | -------- |
| `POST`     | api/v1/user/register |
| `POST`     | api/v1/user/login|



Register User using post request

Body:

```json
{
    "username":"Mr.YY",
    "email":"yy@gmail.com",
    "password":"12345"
}
```

Login using post request

Body:

```json
{
    "username":"Mr.YY",
    "email":"yy@gmail.com",
    "password":"12345"
}
```