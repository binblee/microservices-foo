# API Service

### OAuth2Resource

@OAuth2Resource available in spring boot 1.2.2, not in 1.3.0.

Refer to [Migrating OAuth2 Apps from Spring Boot 1.2 to 1.3](https://spring.io/blog/2015/11/30/migrating-oauth2-apps-from-spring-boot-1-2-to-1-3)

### OAuth2 dependenies in build.gradle

Include OAuth2 dependencies in build.gradle.

```
compile('org.springframework.security.oauth:spring-security-oauth2:2.0.8.RELEASE')
compile('org.springframework.cloud:spring-cloud-starter-security:1.0.0.RELEASE')
```

You will get this message:
```
{"timestamp":1449882650924,"status":401,"error":"Unauthorized","message":"Full authentication is required to access this resource","path":"/ping"}
```