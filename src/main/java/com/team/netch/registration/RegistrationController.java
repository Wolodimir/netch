package com.team.netch.registration;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(@RequestBody RegistrationRequest registrationRequest){
        return registrationService.register(registrationRequest);
    }

    @PostMapping("rise")
    public String riseUser(@RequestParam String email, @RequestParam String adminKey){
        return registrationService.riseUserRole(email, adminKey);
    }

    /*@GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }*/
}
