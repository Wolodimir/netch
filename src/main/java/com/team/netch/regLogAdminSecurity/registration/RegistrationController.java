package com.team.netch.regLogAdminSecurity.registration;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/registration")
@CrossOrigin
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public void register(@RequestBody RegistrationRequest registrationRequest){
            registrationService.register(registrationRequest);
    }

    @PostMapping("rise")
    public String riseUser(@RequestParam String email, @RequestParam String adminKey){
        return registrationService.riseUserRole(email, adminKey);
    }

    @DeleteMapping("delete")
    public String deleteUser(@RequestParam String email, @RequestParam String adminKey){
        return registrationService.deleteUserByEmail(email, adminKey);
    }

    /*@GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }*/
}
