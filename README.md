# Activiti BPM Modeller configuration


## Install on MacOS

Run `./installActiviti.sh` convenience methods to remove the manual steps of setting the Local IP address and
fixing the `rabbitmq` volume mount in `docker-compose.yml`

https://activiti.gitbook.io/activiti-7-developers-guide/getting-started/getting-started-activiti-cloud/getting-started-docker-compose

https://hub.alfresco.com/t5/alfresco-process-services/activiti-installation-in-linux-by-docker-compose-failed-at/td-p/297026


Go to:   http://$DOCKER_IP/modeling

Keycloak credentials _modeler/password_

## References

https://www.activiti.org/quick-start

https://spring.io/blog/2015/03/08/getting-started-with-activiti-and-spring-boot

https://github.com/jbarrez/spring-boot-with-activiti-example

https://www.activiti.org/userguide/

https://spring.io/blog/2015/03/08/getting-started-with-activiti-and-spring-boot

# How to model

http://www.bpmn.org/

https://camunda.com/bpmn/

http://www.bpmn-tool.com/en/tutorial/

http://www.bpmnquickguide.com/view-bpmn-quick-guide/

# How to configure technical implementation

http://javasampleapproach.com/java-integration/activiti-message-event-spring-boot-example

https://spring.io/guides/tutorials/bookmarks/

https://spring.io/guides/gs/messaging-jms/

https://spring.io/guides/tutorials/bookmarks/

http://www.baeldung.com/jackson-annotations

## Admin / Monitoring

Using springboot admin


## Build dockerfile

https://spring.io/guides/gs/spring-boot-docker/

Creates docker image npiper/bpmcontainer

```
mvn install dockerfile:build
```

## Run dockerfile

```
docker run -d -p 8080:8080 npiper/bpmcontainer
```

### Get process instances

http://localhost:8080/runtime/process-instances

# GUI	

https://github.com/martin-grofcik/activiti-crystalball/wiki/getting-started
