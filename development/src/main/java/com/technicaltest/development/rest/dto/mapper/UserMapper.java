package com.technicaltest.development.rest.dto.mapper;

import com.technicaltest.development.rest.dto.user.UserDto;
import com.technicaltest.development.rest.dto.user.UserRequestDto;
import com.technicaltest.development.rest.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity (UserRequestDto dto);
    UserDto toDto (User entity);
}
