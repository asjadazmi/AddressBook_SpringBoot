package com.bridgelabz.addressbookspringboot.dto;

import lombok.Data;

@Data
public class AddressBookResponseDto {
    private String message;
    private Object data;

    public AddressBookResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
