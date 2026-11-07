package kg.edu.university.schedule.schedule;

import jakarta.validation.constraints.NotBlank;

public record LessonRequest(
        @NotBlank String day,
        @NotBlank String time,
        @NotBlank String subject,
        @NotBlank String teacher,
        @NotBlank String room,
        @NotBlank String group
) {
}
