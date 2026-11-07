package kg.edu.university.schedule.schedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, String> {
}
