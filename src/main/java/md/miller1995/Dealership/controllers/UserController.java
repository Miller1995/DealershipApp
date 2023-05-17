package md.miller1995.Dealership.controllers;

import md.miller1995.Dealership.models.entities.UserAuthEntity;
import md.miller1995.Dealership.securities.UserAuthDetails;
import md.miller1995.Dealership.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<HttpStatus> getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAuthDetails userAuthDetails = (UserAuthDetails) authentication.getPrincipal();
        System.out.println(userAuthDetails.getUserEntity());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UserAuthEntity userAuthEntity){
        userService.updateUser(userAuthEntity);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
