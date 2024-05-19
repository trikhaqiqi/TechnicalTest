package com.technicaltest.development.rest.specification;

import com.technicaltest.development.rest.dto.user_office.UserOfficeSearchDto;
import com.technicaltest.development.rest.model.UserOffice;
import org.springframework.data.jpa.domain.Specification;

public class UserOfficeSpecification extends QuerySpecification {

    private Specification<UserOffice> byId(String param) { return attributeContains("nid", param); }

    public Specification<UserOffice> byEntitySearch(UserOfficeSearchDto filter) {
        if (filter == null)
            return null;

        Specification specification = Specification.not(null);
        if (filter.getNid() != null) {
            specification = specification.and(byId(String.valueOf(filter.getNid())));
        }

        return specification;
    }

}
