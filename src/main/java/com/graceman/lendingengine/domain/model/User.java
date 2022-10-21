package com.graceman.lendingengine.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.graceman.lendingengine.domain.model.enums.UserRoles;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String name;
    private int age;
    private String Occupation;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRoles role;

 @JsonBackReference
  @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private Set<Loan> loans;

    @JsonBackReference
    @OneToMany(mappedBy = "user2", cascade = CascadeType.ALL)
    private Set<Loan> loansLent;


}
