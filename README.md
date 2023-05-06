# Spring Boot Rest API User Authentication
=========================
![Spring Boot 3.1.0](https://img.shields.io/badge/Spring%20Boot-2.0-brightgreen.svg)
![Mysql 8.2.4](https://img.shields.io/badge/Mysql-8.2.4-blue.svg)
![JDK 19.0.2](https://img.shields.io/badge/JDK-1.8-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-4.0.0-yellowgreen.svg)


### API Usages

|Method | Endpoint|
| -------- | -------- |
| `POST`     | api/v1/user/save |
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
