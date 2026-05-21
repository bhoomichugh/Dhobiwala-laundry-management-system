# DhobiWaala Laundry Management System

## Local Run

```powershell
cd "backend"
.\mvnw.cmd spring-boot:run
```

Open:

```text
http://localhost:8080/frontend/HomePage/home.html
```

## Deployment Env Vars

Set these on your hosting platform:

```text
DATABASE_URL=jdbc:mysql://<host>:<port>/<database>
DATABASE_USERNAME=<mysql-user>
DATABASE_PASSWORD=<mysql-password>
PORT=8080
```

Most platforms set `PORT` automatically.

## Build

```powershell
cd "backend"
.\mvnw.cmd clean package
```

Start command:

```text
java -jar target/laundry-management-system-1.0.0.jar
```
