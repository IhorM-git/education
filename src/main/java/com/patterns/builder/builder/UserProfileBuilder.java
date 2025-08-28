package com.patterns.builder.builder;

import com.patterns.builder.model.UserProfile;

public class UserProfileBuilder {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phone;
    private String address;

    public UserProfileBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public UserProfileBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserProfileBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public UserProfileBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserProfileBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserProfileBuilder address(String address) {
        this.address = address;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(firstName, lastName, age, email, phone, address);
    }
}
