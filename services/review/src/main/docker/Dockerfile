FROM java:8
VOLUME /tmp
ADD review-0.0.1-SNAPSHOT.jar review.jar
RUN bash -c 'touch /review.jar'
ENTRYPOINT ["java","-jar","/review.jar"]