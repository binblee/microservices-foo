FROM java:8
VOLUME /tmp
ADD book-0.0.1-SNAPSHOT.jar book.jar
RUN bash -c 'touch /book.jar'
ENTRYPOINT ["java","-jar","/book.jar"]