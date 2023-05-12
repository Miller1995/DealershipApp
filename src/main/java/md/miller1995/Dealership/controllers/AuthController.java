package md.miller1995.Dealership.controllers;

import md.miller1995.Dealership.models.dto.UserAuthDTO;
import md.miller1995.Dealership.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<HttpStatus> loginPage(){
        //TODO
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registrationPage(@RequestBody UserAuthDTO userAuthDTO){
        userService.registerUser(userAuthDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}