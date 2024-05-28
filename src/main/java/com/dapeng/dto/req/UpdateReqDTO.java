package com.dapeng.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateReqDTO{

    private Integer id;

    private String username;

    private String password;
    private String phone;

    private String email;
}
