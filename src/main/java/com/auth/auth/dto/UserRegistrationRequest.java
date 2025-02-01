package com.auth.auth.dto;

import lombok.Getter;
import lombok.Setter;

//A serializer in Django REST Framework and a DTO in Java are conceptually similar because they both
// dto may include fields used for validation purposes but doesn't need to be stored in the database
//dto help to communicate backend and frontend like serializer in python
@Getter
@Setter
public class UserRegistrationRequest {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
}
