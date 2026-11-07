package kg.edu.university.schedule.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lessons")
public class LessonEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String teacher;

    @Column(nullable = false)
    private String room;

    @Column(nullable = false)
    private String groupName;

    protected LessonEntity() {
    }

    public LessonEntity(
            String id,
            String day,
            String time,
            String subject,
            String teacher,
            String room,
            String groupName
    ) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
        this.groupName = groupName;
    }

    public Lesson toLesson() {
        return new Lesson(id, day, time, subject, teacher, room, groupName);
    }

    public void update(LessonRequest request) {
        day = request.day();
        time = request.time();
        subject = request.subject();
        teacher = request.teacher();
        room = request.room();
        groupName = request.group();
    }
}
