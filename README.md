# Stock Quotes Manager

This application lets you register quotes for stocks, stocks
must first be registered in the stock-manager application.

## Build

> ./mvnw clean package -DskipTests

> docker build -t stock-quote-manager .

## Run on Docker

> docker container run -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bootdb -p 3306:3306 -d mysql:8

> docker container run -p 8080:8080 -d lucasvilela/stock-manager

> docker run -p 8081:8081 -e STOCK_QUOTE_MANAGER_HOST=172.17.0.1 -e STOCK_MANAGER_HOST=172.17.0.1 -e SPRING_DATASOURCE_URL=jdbc:mysql://172.17.0.1:3306/bootdb stock-quote-manager

You might need to change the environment variables
depending on your system.
