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

## Render Deploy

This repo includes a root `render.yaml` blueprint. On Render:

1. Create a new Blueprint or Web Service from the GitHub repo.
2. Keep the service root as `apc-1-main/laundry-management-system - Copy/backend`.
3. Add these environment variables:

```text
DATABASE_URL=jdbc:mysql://<host>:<port>/<database>
DATABASE_USERNAME=<mysql-user>
DATABASE_PASSWORD=<mysql-password>
```

Start URL after deploy:

```text
https://<your-render-service>.onrender.com/frontend/HomePage/home.html
```

## Build

```powershell
cd "backend"
.\mvnw.cmd clean package
```

Start command:

```text
java -jar target/laundry-management-system-1.0.0.jar
```
