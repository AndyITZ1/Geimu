package com.revature.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteUserFailedException extends RuntimeException {
    private int userId;
    private String email;
}
