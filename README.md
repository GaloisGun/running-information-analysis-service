# running-information-analysis-service
Yufei Wu's first Spring Boot &amp; Spring Data project

Running Instruction:
1. Run mvn clean install under "running-information-analysis-service"

2. cd target

3. java -jar running-information-analysis-services.jar

4. use postman post data to localhost:8080/running

5. go to localhost:8080/orderedResult?page=0&size=2 to see the first page of the ordered results

6. use localhost:8080/delete/runningId=7c08973d-bed4-4cbd-9c28-9282a02a6032 to delete (you can change id)
