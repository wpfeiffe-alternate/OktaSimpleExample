package org.arbfile.oidc.example.repository;

import org.arbfile.oidc.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository
{
    private static final Map<Long, User> userMap;
    static {
        Map<Long, User> testDataMap= new HashMap<>();
        testDataMap.put(0L, new User(0L, "user1", "04513", "Test", "User1"));
        testDataMap.put(1L, new User(1L, "user2", "04513", "Test", "User2"));
        testDataMap.put(2L, new User(2L, "user3", "04513", "Test", "User3"));
        testDataMap.put(3L, new User(3L, "user4", "04513", "Test", "User4"));
        userMap = Collections.unmodifiableMap(testDataMap);
    }

    public List<User> findAll()
    {
        return this.userMap.values().stream().collect(Collectors.toList());
    }

    public User findOne(Long id)
    {
        return this.userMap.get(id);
    }
}
