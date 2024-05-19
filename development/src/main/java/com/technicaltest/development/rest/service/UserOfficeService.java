package com.technicaltest.development.rest.service;

import com.technicaltest.development.rest.dto.mapper.UserOfficeMapper;
import com.technicaltest.development.rest.dto.user_office.UserOfficeDto;
import com.technicaltest.development.rest.dto.user_office.UserOfficeRequestDto;
import com.technicaltest.development.rest.dto.user_office.UserOfficeSearchDto;
import com.technicaltest.development.rest.model.UserOffice;
import com.technicaltest.development.rest.repository.UserOfficeRepository;
import com.technicaltest.development.rest.specification.UserOfficeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserOfficeService {

    @Autowired
    UserOfficeMapper mapper;

    @Autowired
    UserOfficeRepository repository;

    private UserOfficeSpecification getUserOfficeSpecification() { return new UserOfficeSpecification(); }

    public List<UserOfficeDto> list(UserOfficeSearchDto filter) {
        Specification<UserOffice> specification = getUserOfficeSpecification().byEntitySearch(filter);
        return repository.findAll(specification).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public Page<UserOfficeDto> page(UserOfficeSearchDto filter, Pageable pageable) {
        Specification<UserOffice> specification = getUserOfficeSpecification().byEntitySearch(filter);
        return repository.findAll(specification, pageable).map(mapper::toDto);
    }

    public Optional<UserOfficeDto> findById(String id) { return repository.findById(Integer.valueOf(id)).map(mapper::toDto); }

    public UserOfficeDto create(UserOfficeRequestDto input) {
        UserOffice userOffice = mapper.toEntity(input);
        repository.save(userOffice);
        return mapper.toDto(userOffice);
    }

    public UserOffice updateData(UserOffice oldData, UserOffice newData) {
        UserOffice updatedData = oldData;

        if (newData.getNid() != null)
            updatedData.setNid(newData.getNid());
        if (newData.getOfficeId() != null)
            updatedData.setOfficeId(newData.getOfficeId());

        return updatedData;
    }

    public UserOfficeDto update(String id, UserOfficeRequestDto updateData) {
        UserOffice oldData = repository.findById(Integer.valueOf(id)).orElseThrow();
        UserOffice newData = mapper.toEntity(updateData);

        newData = this.updateData(oldData, newData);
        repository.save(newData);
        return mapper.toDto(newData);
    }

    public void hardDelete(Integer id) {
        repository.deleteById(id);
    }

}
