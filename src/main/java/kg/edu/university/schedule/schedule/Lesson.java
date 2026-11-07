package kg.edu.university.schedule.schedule;

public record Lesson(
        String id,
        String day,
        String time,
        String subject,
        String teacher,
        String room,
        String group
) {
}
