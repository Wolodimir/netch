package com.team.netch.regLogAdminSecurity.appUser;


import com.team.netch.regLogAdminSecurity.registration.token.ConfirmationToken;
import com.team.netch.regLogAdminSecurity.registration.token.ConfirmationTokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final AppUserRepo appUserRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public AppUserService(AppUserRepo appUserRepo,
                          BCryptPasswordEncoder bCryptPasswordEncoder,
                          ConfirmationTokenService confirmationTokenService) {
        this.appUserRepo = appUserRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser user){
        boolean userExists = appUserRepo.findByEmail(user.getEmail()).isPresent();
        if(userExists){
            //chek of attributes are the same and
            //if email not confirmed send confirmation email

            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        appUserRepo.save(user);

        //make a token with UUID
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        //No need to make confirmation token table
        //confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public List<AppUser> showAllUsers() {
        return appUserRepo.findAll();
    }

    /*public int enableUser(String email) {
        return appUserRepo.enableAppUser(email);
    }*/
}
