package com.technicaltest.development.rest.specification;

import org.springframework.data.jpa.domain.Specification;

public abstract class QuerySpecification<T> {

    public Specification<T> attributeContains(String attribute, String value) {
        if (value != null && !value.isBlank()) {
            value = "%" + value.toLowerCase() + "%";
        }
        final String finalText = value;
        return (root, query, cb) -> {
            if (finalText == null || finalText.isBlank()) {
                return null;
            }
            return cb.like(
                    cb.lower(root.get(attribute)),
                    finalText
            );
        };
    }

}
