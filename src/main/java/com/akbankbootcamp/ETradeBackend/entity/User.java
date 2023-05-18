package com.akbankbootcamp.ETradeBackend.entity;

import com.akbankbootcamp.ETradeBackend.enums.EnumStatus;
import com.akbankbootcamp.ETradeBackend.enums.EnumUserType;
import com.akbankbootcamp.ETradeBackend.general.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "INDIVIDUAL")
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Individual", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Individual", sequenceName = "Individual_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "USERNAME", length = 50, nullable = false)
    private String username;

    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 11)
    private String phoneNumber;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "USER_TYPE", length = 50)
    @Enumerated(EnumType.STRING)
    private EnumUserType UserTYpe;

    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Comment> comments;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }
    public EnumUserType getUserTYpe() {
        return UserTYpe;
    }

    public void setUserTYpe(EnumUserType userTYpe) {
        UserTYpe = userTYpe;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
