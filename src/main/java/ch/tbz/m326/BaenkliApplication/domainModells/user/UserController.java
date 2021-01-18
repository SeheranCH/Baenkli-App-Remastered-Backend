package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.domainModells.user.mapper.UserMapper;
import ch.tbz.m326.BaenkliApplication.domainModells.user.mapper.UserMapperDTOWithoutPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@EnableGlobalMethodSecurity(prePostEnabled = true)
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userSerivce;
    private UserMapper userMapper;
    private UserMapperDTOWithoutPassword userMapperDTOWithoutPassword;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper, UserMapperDTOWithoutPassword userMapperDTOWithoutPassword) {
        this.userSerivce = userService;
        this.userMapper = userMapper;
        this.userMapperDTOWithoutPassword = userMapperDTOWithoutPassword;
    }

    @PreAuthorize("hasAuthority('USERS_SEE')")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTOWithoutPassword> findById(@PathVariable String id) {
        User user = userSerivce.findById(id);
        return new ResponseEntity<>(userMapperDTOWithoutPassword.toDTO(user), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USERS_SEE')")
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<UserDTOWithoutPassword>> findAll() {
        List<User> users = userSerivce.findAll();
        return new ResponseEntity<>(userMapperDTOWithoutPassword.toDTOs(users), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        userDTO = userMapper.toDTO(userSerivce.save(userMapper.fromDTO(userDTO)));
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USERS_UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTOWithoutPassword> updateById(@PathVariable String id, @RequestBody UserDTOWithoutPassword userDTOWithoutPassword) {
        User user = userSerivce.updateById(id, userMapperDTOWithoutPassword.fromDTO(userDTOWithoutPassword));
        return new ResponseEntity<>(userMapperDTOWithoutPassword.toDTO(user), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USERS_DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userSerivce.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
