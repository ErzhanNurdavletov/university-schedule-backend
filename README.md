# University Schedule Backend

Spring Boot REST API for the Flutter mobile application.

## Run

Start PostgreSQL:

```powershell
docker compose up -d
```

Then start the backend:

```powershell
.\mvnw.cmd spring-boot:run
```

If Maven Wrapper is not generated yet:

```powershell
mvn spring-boot:run
```

Stop PostgreSQL:

```powershell
docker compose down
```

The backend connects to PostgreSQL using the defaults from `application.yml`.
The database and demo records are created automatically on first startup.

## Demo accounts

- `student@university.kz` / `password`
- `teacher@university.kz` / `password`

## Endpoints

- `POST /api/auth/login`
- `GET /api/schedule?role=STUDENT`
- `POST /api/schedule` — только преподаватель, заголовок `X-User-Role: TEACHER`
- `PUT /api/schedule/{id}` — только преподаватель, заголовок `X-User-Role: TEACHER`
- `DELETE /api/schedule/{id}` — только преподаватель, заголовок `X-User-Role: TEACHER`
