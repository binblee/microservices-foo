FROM java:8
VOLUME /tmp
ADD bookreview-0.0.1-SNAPSHOT.jar bookreview.jar
RUN bash -c 'touch /bookreview.jar'
ENTRYPOINT ["java","-jar","/bookreview.jar"]