package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.domainModells.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userSerivce;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userSerivce = userService;
        this.userMapper = userMapper;
    }

    @PreAuthorize("hasAuthority('USERS_SEE')")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userSerivce.findById(id);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USERS_SEE')")
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userSerivce.findAll();
        return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        userDTO = userMapper.toDTO(userSerivce.save(userMapper.fromDTO(userDTO)));
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USERS_UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable String id, @RequestBody UserDTO userDTO) {
        User user = userSerivce.updateById(id, userMapper.fromDTO(userDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USERS_DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userSerivce.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
