package com.team.netch.auth;


import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo{

    Optional<AppUser> selectAppUserByUsername(String username);
}
