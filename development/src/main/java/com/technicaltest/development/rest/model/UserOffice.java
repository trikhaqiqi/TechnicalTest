package com.technicaltest.development.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_user_office")
public class UserOffice {

    @Id
    @Column(name = "nid")
    private Integer nid;

    @Column(name = "office_id")
    private Integer officeId;

}
