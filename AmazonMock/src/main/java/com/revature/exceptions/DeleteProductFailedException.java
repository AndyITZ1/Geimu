package com.revature.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductFailedException extends RuntimeException {
    private int productId;
    private String productName;
}
