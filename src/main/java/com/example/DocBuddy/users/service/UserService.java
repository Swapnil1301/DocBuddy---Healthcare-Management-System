//package com.example.DocBuddy.users.service;
//
//import com.example.DocBuddy.res.Response;
//import com.example.DocBuddy.users.dto.UpdatePasswordRequest;
//import com.example.DocBuddy.users.dto.UserDTO;
//import com.example.DocBuddy.users.entity.User;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.List;
//
//public interface UserService {
//
//
//    User getCurrentUser();
//
//    Response<UserDTO> getMyUserDetails();
//
//    Response<UserDTO> getUserById(Long userId);
//
//    Response<List<UserDTO>> getAllUsers();
//
//    Response<?> updatePassword(UpdatePasswordRequest updatePasswordRequest);
//
//    Response<?> uploadProfilePicture(MultipartFile file);
//
//    Response<?> uploadProfilePictureToS3(MultipartFile file);
//
//}
