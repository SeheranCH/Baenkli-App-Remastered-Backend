package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.domainModells.authority.Authority;
import ch.tbz.m326.BaenkliApplication.domainModells.role.Role;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.*;

import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<User> userList;

    private List<Role> roleList;

    private HashSet<Role> roleHashSet1;

    private HashSet<Role> roleHashSet2;

    private HashSet<Role> roleHashSet3;

    private List<Authority> authorityList;

    private HashSet<Authority> authorityHashSet1;

    private HashSet<Authority> authorityHashSet2;

    private HashSet<Authority> authorityHashSet3;


    @Mock
    private User user1;

    @Mock
    private User user2;

    @Mock
    private User user3;

    @Mock
    private Role role1;

    @Mock
    private Role role2;

    @Mock
    private Role role3;

    @Mock
    private Authority authority1;

    @Mock
    private Authority authority2;

    @Mock
    private Authority authority3;


    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        role1 = new Role();
        role2 = new Role();
        role3 = new Role();
        roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role1);
        roleList.add(role3);

        authority1 = new Authority();
        authority2 = new Authority();
        authority3 = new Authority();
        authorityList = new ArrayList<>();
        authorityList.add(authority1);
        authorityList.add(authority2);
        authorityList.add(authority3);
        authorityHashSet1 = new HashSet<>();
        authorityHashSet2 = new HashSet<>();
        authorityHashSet3 = new HashSet<>();

        for(Authority authority : authorityList){
            authority.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        authority1.setName("USER_SEE");
        authority2.setName("USERS_UPDATE");
        authority3.setName("USERS_DELETE");

        for(Authority authority: authorityList){
            authorityHashSet1.add(authority);
        }
        authorityHashSet2.add(authority1);

        for(Role role : roleList){
            role.setId(UUID.randomUUID().toString().replace("-", ""));
        }
        role1.setAuthorities(authorityHashSet1);
        role2.setAuthorities(authorityHashSet2);
        role3.setAuthorities(authorityHashSet3);

        roleHashSet1 = new HashSet<>();
        roleHashSet2 = new HashSet<>();
        roleHashSet3 = new HashSet<>();

        roleHashSet1.add(role1);
        roleHashSet1.add(role3);
        roleHashSet2.add(role2);
        roleHashSet3.add(role3);


        for (User user : userList){
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setAccountExpirationDate(LocalDate.parse("2099-12-12"));
            user.setCredentialsExpirationDate(LocalDate.parse("2099-12-12"));
            user.setEmail(RandomStringUtils.randomAlphanumeric(9) + "@gmail.com");
            user.setEnabled(true);
            user.setPassword(RandomStringUtils.randomAlphanumeric(10));
            user.setLocked(false);
            user.setUsername(RandomStringUtils.randomAlphanumeric(4));
        }
        user1.setRoles(roleHashSet1);
        user2.setRoles(roleHashSet2);
        user3.setRoles(roleHashSet3);
    }

    @Test
    void findById() throws Exception {

    }

}
