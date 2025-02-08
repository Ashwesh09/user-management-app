package com.user.management.app.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class UserResponse{
    public List<User> users;
    public int total;
    public int skip;
    public int limit;
}