package kg.edu.university.schedule.config;

import kg.edu.university.schedule.auth.UserEntity;
import kg.edu.university.schedule.auth.UserRepository;
import kg.edu.university.schedule.auth.UserRole;
import kg.edu.university.schedule.schedule.LessonEntity;
import kg.edu.university.schedule.schedule.LessonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner seedDatabase(
            UserRepository userRepository,
            LessonRepository lessonRepository
    ) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new UserEntity(
                        "student-1",
                        "Айдана Студент",
                        "student@university.kg",
                        "password",
                        UserRole.STUDENT
                ));
                userRepository.save(new UserEntity(
                        "teacher-1",
                        "Эрлан Преподаватель",
                        "teacher@university.kg",
                        "password",
                        UserRole.TEACHER
                ));
            }

            if (lessonRepository.count() == 0) {
                lessonRepository.save(new LessonEntity(
                        "lesson-1", "Понедельник", "09:00 - 10:30",
                        "Математический анализ", "А. С. Иванов", "301", "ИС-22"
                ));
                lessonRepository.save(new LessonEntity(
                        "lesson-2", "Понедельник", "10:45 - 12:15",
                        "Программирование", "Е. Н. Петров", "204", "ИС-22"
                ));
                lessonRepository.save(new LessonEntity(
                        "lesson-3", "Среда", "09:00 - 10:30",
                        "Базы данных", "М. К. Алиева", "Лаб. 2", "ИС-22"
                ));
                lessonRepository.save(new LessonEntity(
                        "lesson-4", "Пятница", "13:00 - 14:30",
                        "Компьютерные сети", "Д. Р. Садыков", "405", "ИС-22"
                ));
            }
        };
    }
}
