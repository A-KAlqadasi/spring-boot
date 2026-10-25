package com.amigoscode.features.users.updateProfile;

import java.time.LocalDate;

public record UpdateProfileRequest(String firstName, String lastName, LocalDate DateOfBirth) {
}
