package ch.tbz.m326.BaenkliApplication.domainModells.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Test {


    @Mock
    private User user;

    private List<User> userList;

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        userList.add(user);
    }


    @org.junit.jupiter.api.Test
    void findById() throws Exception {

    }

}
