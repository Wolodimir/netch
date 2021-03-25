package com.team.netch.security;

public class AppUserPermission {

    private final String permission;

    public AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
