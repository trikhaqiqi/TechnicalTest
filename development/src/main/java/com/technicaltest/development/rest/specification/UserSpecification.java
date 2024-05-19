package com.technicaltest.development.rest.specification;

import com.technicaltest.development.rest.dto.user.UserSearchDto;
import com.technicaltest.development.rest.model.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification extends QuerySpecification {

    private Specification<User> byId(String param) { return attributeContains("id", param); }

    public Specification<User> byEntitySearch(UserSearchDto filter) {
        if (filter == null)
            return null;

        Specification specification = Specification.not(null);
        if (filter.getId() != null) {
            specification = specification.and(byId(String.valueOf(filter.getId())));
        }

        return specification;
    }

}
