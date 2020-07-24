FROM openjdk:8-jdk-alpine
ADD target/microservice-api-0.0.1-SNAPSHOT.jar docker-springboot.jar
ENTRYPOINT exec java -Xms128m -Xmx256m -XX:MaxMetaspaceSize=128m -XX:CompressedClassSpaceSize=256m -Xss256k -Xmn8m -XX:InitialCodeCacheSize=4m -XX:ReservedCodeCacheSize=128m -XX:MaxDirectMemorySize=16m  -XX:MinHeapFreeRatio=10 -XX:MaxHeapFreeRatio=70 -jar /docker-springboot.jar
EXPOSE 8080
