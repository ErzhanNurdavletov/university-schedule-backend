package kg.edu.university.schedule.auth;

public record UserResponse(
        String id,
        String name,
        String email,
        UserRole role
) {
}
