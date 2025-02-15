package com.trs.trs_user_service.model;


import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String email;
    private Long contact;
    private String f_name;
    private String l_name;
    private Date dob;
    private String gender;
    private String country;
}
