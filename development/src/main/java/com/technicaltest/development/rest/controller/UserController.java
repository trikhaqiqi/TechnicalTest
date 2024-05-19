package com.technicaltest.development.rest.controller;

import com.technicaltest.development.rest.dto.user.UserDto;
import com.technicaltest.development.rest.dto.user.UserRequestDto;
import com.technicaltest.development.rest.dto.user.UserSearchDto;
import com.technicaltest.development.rest.service.UserService;
import com.technicaltest.development.rest.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/yDEEW3KjymTG9yjj9830")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/list")
    public ResponseEntity<?> list(UserSearchDto filter) {
        try {
            List<UserDto> dto = service.list(filter);
            return new ResponseEntity<>(new ApiResponse<>("200", "Success", dto), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }

    @GetMapping("/page")
    public ResponseEntity<?> page(UserSearchDto filter, Pageable pageable){
        try {
            Page<UserDto> page = service.page(filter, pageable);
            return new ResponseEntity<>(new ApiResponse<>("200","Success",page), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<UserDto> findById = service.findById(id);
        if (findById.isPresent())
            return new ResponseEntity<>(new ApiResponse<>("200","Success",findById),HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse<>("404","No Data","NOT_FOUND"),HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody UserRequestDto data) {
        try {
            UserDto dto = service.create(data);
            return new ResponseEntity<>(new ApiResponse<>("200", "Success", dto), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(new ApiResponse<>("422", "Failed", "UNPROCESSABLE_ENTITY"), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserRequestDto input) {
        Optional<UserDto> dto = service.findById(id);
        if (dto.isPresent()) {
            UserDto dto1 = service.update(id, input);
            return new ResponseEntity<>(new ApiResponse<>("200", "success", dto1), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse<>("404", "failed", "NOT_FOUND"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDelete(@PathVariable Integer id) {
        Optional<UserDto> dto = service.findById(String.valueOf(id));
        if (dto.isPresent()) {
            service.hardDelete(id);
            return new ResponseEntity<>(new ApiResponse<>("200", "success", "Data has been deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse<>("404", "failed", "NOT_FOUND"), HttpStatus.NOT_FOUND);
    }
}
