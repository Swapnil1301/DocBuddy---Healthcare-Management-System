package com.example.DocBuddy.users.service;

import com.example.DocBuddy.res.Response;
import com.example.DocBuddy.users.dto.LoginRequest;
import com.example.DocBuddy.users.dto.LoginResponse;
import com.example.DocBuddy.users.dto.RegistrationRequest;
import com.example.DocBuddy.users.dto.ResetPasswordRequest;

public interface AuthService {

    Response<String> register(RegistrationRequest request);

    Response<LoginResponse> login(LoginRequest loginRequest);

    Response<?> forgetPassword(String email);

    Response<?> updatePasswordViaResetCode(ResetPasswordRequest resetPasswordRequest);
}
