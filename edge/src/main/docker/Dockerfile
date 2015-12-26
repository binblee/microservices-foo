FROM java:8
VOLUME /tmp
ADD edge-0.0.1-SNAPSHOT.jar edge.jar
RUN bash -c 'touch /edge.jar'
ENTRYPOINT ["java","-jar","/edge.jar"]