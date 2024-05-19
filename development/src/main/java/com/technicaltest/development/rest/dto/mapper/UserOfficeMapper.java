package com.technicaltest.development.rest.dto.mapper;

import com.technicaltest.development.rest.dto.user_office.UserOfficeDto;
import com.technicaltest.development.rest.dto.user_office.UserOfficeRequestDto;
import com.technicaltest.development.rest.model.UserOffice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserOfficeMapper {
    UserOffice toEntity (UserOfficeRequestDto dto);
    UserOfficeDto toDto (UserOffice entity);
}
