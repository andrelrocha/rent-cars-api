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
import rocha.andre.rentcars.domain.users.UserReturnDTO;

@RestController
@RequestMapping("/login")
public class UsersController {
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private PerformLoginUseCase performLoginUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity performLogin(@RequestBody @Valid UserDTO data) {
        var tokenJWT = performLoginUseCase.performLogin(data);
        return ResponseEntity.ok(tokenJWT);
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity createUser(@RequestBody @Valid UserDTO data) {
        var newUser = createUserUseCase.createUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
