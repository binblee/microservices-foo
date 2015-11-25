# Edge Server

### Check which instances are registered

```bash
curl -s -H "Accept: application/json" http://localhost:8761/eureka/apps | jq '.applications.application[] | {service: .name, ip: .instance[0].ipAddr, port: .instance[0].port."$"}'
```

### Hit edge server

For bookreview services, other services are not accessible through edge server.

```bash
curl http://localhost:8765/br/br/1
```

Please be noted that we have two 'br' in the URL.