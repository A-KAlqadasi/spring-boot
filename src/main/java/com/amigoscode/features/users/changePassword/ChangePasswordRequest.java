package com.amigoscode.features.users.changePassword;

public record ChangePasswordRequest(String currentPassword, String newPassword, String confirmNewPassword) {
}
