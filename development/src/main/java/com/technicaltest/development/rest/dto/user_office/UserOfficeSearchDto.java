package com.technicaltest.development.rest.dto.user_office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOfficeSearchDto {
    private Integer nid;
    private Integer officeId;
}
