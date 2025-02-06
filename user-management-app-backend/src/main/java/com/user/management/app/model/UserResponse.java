package com.user.management.app.model;

import com.user.management.app.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse{
    public List<User> users;
    public int total;
    public int skip;
    public int limit;
}