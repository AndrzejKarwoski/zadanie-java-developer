# Wymagania:
Java 17
Maven

## Uruchomienie aplikacji

Możesz uruchomić aplikację w trybie developerskim(umożliwia zmiany live) poprzez:
```shell script
mvn compile quarkus:dev
```

Lub spakować aplikację i uruchomić plik jar.

```shell script
mvn package
java -jar target\quarkus-app\quarkus-run.jar
```

Aplikacja uruchomi się na porcie 8000.