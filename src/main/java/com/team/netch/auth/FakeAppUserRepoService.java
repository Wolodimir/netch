package com.team.netch.auth;

import org.assertj.core.util.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.team.netch.security.AppUserRole.ADMIN;
import static com.team.netch.security.AppUserRole.USER;

@Repository("fake")
public class FakeAppUserRepoService implements AppUserRepo{
    private final PasswordEncoder passwordEncoder;

    public FakeAppUserRepoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<AppUser> selectAppUserByUsername(String username) {
        return getAppUsers()
                .stream()
                .filter(appUser -> username.equals(appUser.getUsername()))
                .findFirst();
    }

    private List<AppUser> getAppUsers(){

        List<AppUser> appUsers = Lists.newArrayList(
            new AppUser("annasmith",
                        passwordEncoder.encode("password"),
                        USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                    ),
            new AppUser("linda",
                    passwordEncoder.encode("password"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
                )
        );

        return appUsers;
    }

}
