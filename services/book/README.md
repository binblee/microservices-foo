# Book Service

### Model

A book has below properties:

- name
- author
- price


### Allow multiple instances running in on host

```yml
eureka:
  instance:
    instanceId: ${spring.application.name}:${spring.application.instance_id:${random.value}}
```
