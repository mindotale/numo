# Numo Management Application

## Starting Application
To run the application in Docker execute the following command in Terminal from the project directory:
```shell
docker-compose up
```
It may take a couple of minutes to build the application image for the first time. Subsequent runs will be fast.
Server will start on port `8080` and will be ready to accept requests after the following message is printed in log:
> Started NumoManagementApplication in ... seconds

To stop the application execute the following command in Terminal:
```shell
docker-compose down
```

## Running Tests
To run all unit and integration tests in Docker execute the following command:
```shell
docker-compose run --rm test
```

Await for the test results to be logged. They will look like this:
```shell
Test Coverage:
    - Class Coverage: 100%
    - Method Coverage: 93.8%
    - Branch Coverage: 93.5%
    - Line Coverage: 99.1%
    - Instruction Coverage: 98%
    - Complexity Coverage: 92%
```
