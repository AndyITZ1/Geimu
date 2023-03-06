FROM amazoncorretto:17
COPY target/AmazonMock-0.0.1-SNAPSHOT.war AmazonMock.war
ENTRYPOINT [ "java", "-war", "/AmazonMock.war" ]
EXPOSE 7070