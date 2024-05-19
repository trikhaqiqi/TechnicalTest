package com.technicaltest.development.rest.service;

import com.technicaltest.development.rest.dto.mapper.UserMapper;
import com.technicaltest.development.rest.dto.user.UserDto;
import com.technicaltest.development.rest.dto.user.UserRequestDto;
import com.technicaltest.development.rest.dto.user.UserSearchDto;
import com.technicaltest.development.rest.model.User;
import com.technicaltest.development.rest.repository.UserRepository;
import com.technicaltest.development.rest.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    @Autowired
    UserRepository repository;

    private UserSpecification getUserSpecification() { return new UserSpecification(); }

    public List<UserDto> list(UserSearchDto filter) {
        Specification<User> specification = getUserSpecification().byEntitySearch(filter);
        return repository.findAll(specification).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public Page<UserDto> page(UserSearchDto filter, Pageable pageable) {
        Specification<User> specification = getUserSpecification().byEntitySearch(filter);
        return repository.findAll(specification, pageable).map(mapper::toDto);
    }

    public Optional<UserDto> findById(String id) { return repository.findById(Integer.valueOf(id)).map(mapper::toDto); }

    public UserDto create(UserRequestDto input) {
        User user = mapper.toEntity(input);
        repository.save(user);
        return mapper.toDto(user);
    }

    public User updateData(User oldData, User newData) {
        User updatedData = oldData;

        if (newData.getName() != null && !newData.getName().isBlank())
            updatedData.setName(newData.getName());
        if (newData.getAddress() != null && !newData.getAddress().isBlank())
            updatedData.setAddress(newData.getAddress());


        return updatedData;
    }

    public UserDto update(String id, UserRequestDto updateData) {
        User oldData = repository.findById(Integer.valueOf(id)).orElseThrow();
        User newData = mapper.toEntity(updateData);

        newData = this.updateData(oldData, newData);
        repository.save(newData);
        return mapper.toDto(newData);
    }

    public void hardDelete(Integer id) {
        repository.deleteById(id);
    }

}
