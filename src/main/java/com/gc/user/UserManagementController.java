package com.gc.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.gc.security.ApplicationUserRole;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/users")
public class UserManagementController {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "James Bond"),
            new User(2, "Maria Jones"),
            new User(3, "Anna Smith")
    );

//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<User> getAllUsers() {
        System.out.println("getAllUsers");        
        return USERS;
    }

//    experiment with @ResponseStatus(value = HttpStatus.CREATED)
//    also can return new ResponseEntity<>(user, HttpStatus.CREATED) and will show response 201 in Postman
//    see: https://www.youtube.com/watch?v=ZBCSF3Uik0g&list=PLGRDMO4rOGcN-8NFRfIBkbdJuifnWkPCR&index=16
//    @PostMapping
//    @PreAuthorize("hasAuthority('user:write')")
//    public void registerNewUser(@RequestBody User user) {  //@RequestBody to convert the JSON object to java User object
//        System.out.println("registerNewUser");
//        System.out.println(user);
//    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('admin:all')")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("deleteUser");
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        System.out.println("updateUser");
        System.out.println(String.format("%s %s", userId, user));
    }
}


