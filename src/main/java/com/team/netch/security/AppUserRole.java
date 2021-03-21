package com.team.netch.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum AppUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(AppUserPermission.COURSE_READ,
            AppUserPermission.COURSE_WRITE,
            AppUserPermission.STUDENT_READ,
            AppUserPermission.STUDENT_WRITE));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
