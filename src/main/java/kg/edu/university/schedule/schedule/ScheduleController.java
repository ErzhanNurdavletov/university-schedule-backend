package kg.edu.university.schedule.schedule;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Lesson> getSchedule(@RequestParam(defaultValue = "STUDENT") String role) {
        return scheduleService.getSchedule(role);
    }

    @PostMapping
    public Lesson create(
            @Valid @RequestBody LessonRequest request,
            @RequestHeader(value = "X-User-Role", defaultValue = "") String role
    ) {
        return scheduleService.create(request, role);
    }

    @PutMapping("/{id}")
    public Lesson update(
            @PathVariable String id,
            @Valid @RequestBody LessonRequest request,
            @RequestHeader(value = "X-User-Role", defaultValue = "") String role
    ) {
        return scheduleService.update(id, request, role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Role", defaultValue = "") String role
    ) {
        scheduleService.delete(id, role);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
