# running-information-analysis-service
Yufei Wu's first Spring Boot &amp; Spring Data project

Running Instruction:
1. run mvn clean install under "running-information-analysis-service"

2. run docker-compose up in the same place for the database

3. cd target

4. java -jar running-information-analysis-services.jar

5. use postman post data to localhost:8080/running

6. go to localhost:8080/orderedResult?page=0&size=2 to see the first page of the ordered results

7. use localhost:8080/delete/runningId=7c08973d-bed4-4cbd-9c28-9282a02a6032 to delete (you can change id)
