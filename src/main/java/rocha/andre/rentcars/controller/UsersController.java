package rocha.andre.rentcars.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocha.andre.rentcars.domain.users.UseCase.CreateUserUseCase;
import rocha.andre.rentcars.domain.users.UseCase.PerformLoginUseCase;
import rocha.andre.rentcars.domain.users.UserDTO;
import rocha.andre.rentcars.domain.users.UserLoginDTO;
import rocha.andre.rentcars.domain.users.UserReturnDTO;
import rocha.andre.rentcars.service.UsersService;

@RestController
@RequestMapping("/login")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    @Transactional
    public ResponseEntity performLogin(@RequestBody @Valid UserDTO data) {
        var tokenJWT = usersService.performLogin(data);
        return ResponseEntity.ok(tokenJWT);
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity createUser(@RequestBody @Valid UserDTO data) {
        var newUser = usersService.createUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/forgot_password")
    @Transactional
    public ResponseEntity forgotPassword(@RequestBody UserLoginDTO data) {
        var stringSuccess= usersService.forgotPassword(data);
        return ResponseEntity.ok(stringSuccess);
    }
}
