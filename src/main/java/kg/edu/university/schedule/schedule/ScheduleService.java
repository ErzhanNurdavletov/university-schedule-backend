package kg.edu.university.schedule.schedule;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleService {

    private final LessonRepository lessonRepository;

    public ScheduleService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getSchedule(String role) {
        return lessonRepository.findAll().stream()
                .map(LessonEntity::toLesson)
                .toList();
    }

    public Lesson create(LessonRequest request, String role) {
        requireTeacher(role);
        LessonEntity lesson = new LessonEntity(
                UUID.randomUUID().toString(),
                request.day(),
                request.time(),
                request.subject(),
                request.teacher(),
                request.room(),
                request.group()
        );
        return lessonRepository.save(lesson).toLesson();
    }

    public Lesson update(String id, LessonRequest request, String role) {
        requireTeacher(role);
        LessonEntity lesson = findById(id);
        lesson.update(request);
        return lessonRepository.save(lesson).toLesson();
    }

    public void delete(String id, String role) {
        requireTeacher(role);
        if (!lessonRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пара не найдена");
        }
        lessonRepository.deleteById(id);
    }

    private LessonEntity findById(String id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Пара не найдена"
                ));
    }

    private void requireTeacher(String role) {
        if (!"TEACHER".equalsIgnoreCase(role)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Только преподаватель может изменять расписание"
            );
        }
    }
}
