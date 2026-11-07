# Статус выполнения ТЗ

Учебный проект: мобильное приложение университета с расписанием занятий.

## Итоговая таблица

| Требование | Статус | Где реализовано |
|---|---|---|
| Cross-platform mobile app | Выполнено | Flutter-проект `D:\AndroidStudioProjects\university_schedule_mobile` |
| Flutter обязателен | Выполнено | `university_schedule_mobile/lib` |
| Мобильное приложение взаимодействует с сервером | Выполнено | `D:\AndroidStudioProjects\university_schedule_mobile\lib\core\api_client.dart`, `AuthRepository`, `ScheduleRepository` |
| Backend на Spring Boot | Выполнено | `pom.xml`, `src/main/java` |
| PostgreSQL | Выполнено | `docker-compose.yml`, Spring Data JPA и `src/main/resources/application.yml` |
| State management | Выполнено | Bloc в `D:\AndroidStudioProjects\university_schedule_mobile\lib\features\auth\bloc` и `...\schedule\bloc` |
| Асинхронность | Выполнено | `Future`, `async/await`, асинхронные HTTP-запросы и Bloc handlers |
| Авторизация | Частично выполнено | `POST /api/auth/login`, роли `STUDENT` и `TEACHER` |
| Просмотр расписания | Выполнено | `GET /api/schedule?role=STUDENT` и экран `SchedulePage` |
| Добавление расписания преподавателем | Выполнено | `POST /api/schedule`, форма в `SchedulePage`, `LessonCreated` |
| Редактирование расписания преподавателем | Выполнено | `PUT /api/schedule/{id}`, форма в `SchedulePage`, `LessonUpdated` |
| Удаление расписания преподавателем | Выполнено | `DELETE /api/schedule/{id}`, кнопка удаления, `LessonDeleted` |
| Публикация на GitHub | **Не выполнено** | Оба проекта пока не являются Git-репозиториями и не имеют remote |

## Что уже работает

### Backend

- Spring Boot REST API.
- PostgreSQL через Docker Compose.
- JPA-сущности пользователей и занятий.
- Автоматическое создание демо-данных при первом запуске.
- Демо-роли `STUDENT` и `TEACHER`.
- Эндпоинты:

```text
POST /api/auth/login
GET  /api/schedule?role=STUDENT
POST /api/schedule
PUT  /api/schedule/{id}
DELETE /api/schedule/{id}
```

Изменение расписания разрешено только при заголовке
`X-User-Role: TEACHER`. Студент может только просматривать расписание.

### Mobile

- Flutter-приложение.
- Bloc для авторизации и загрузки расписания.
- Состояния `loading`, `success`, `failure`.
- Асинхронные HTTP-запросы к Spring Boot.
- Отдельные репозитории для авторизации и расписания.
- Обновление расписания через pull-to-refresh.

## Что осталось за пределами текущей реализации

### Публикация на GitHub

Нужно:

1. Создать Git-репозитории или объединённый репозиторий.
2. Добавить оба проекта в Git.
3. Создать `.gitignore` для Java, Maven, Flutter, Android Studio и Docker.
4. Создать remote GitHub.
5. Выполнить commit и push.

## Вывод

Основная часть ТЗ выполнена: Flutter-клиент, связь с Spring Boot, Bloc,
асинхронность, роли, PostgreSQL и CRUD расписания преподавателя работают.

Публикация на GitHub намеренно не выполнялась по решению пользователя.
