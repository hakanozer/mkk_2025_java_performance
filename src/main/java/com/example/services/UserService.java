package com.example.services;

import com.example.entities.Customer;
import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    final private List<Map<String, Object>> list;
    final private UserRepository userRepository;
    String name = "";

    public Customer save(Customer user) {
        userRepository.save(user);
        return user;
        /*
        for (int i = 0; i < 1000; i++) {
            //list.get(0).put("id"+i, i);
        }

        //list.get(0).clear();
        String data = "";
        for (int i = 0; i < 1000; i++) {
            data += "Ali " + i;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            builder.append(data + "\n");
        }
        System.out.println(builder.toString());

        Integer i = 0;
        for (int j = 0; j < 1000; j++) {
            i += 10;
        }

        List<Customer> users = result();
        long start = System.currentTimeMillis();
        users.parallelStream().forEach(customer -> {
            try {
                Thread.sleep(100);
            }catch (Exception e){}
                System.out.println(customer);
            });
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        */
    }

    public List<Customer> findAll() {
        System.out.println(list.get(0));
        return userRepository.findAll();
    }

    // stream -> 103708
    // paralel Stream -> 8075
    public List<Customer> result() {
        List<Customer> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Customer user = new Customer();
            user.setUsername("Name" + i);
            user.setPassword("Password" + i);
            users.add(user);
        }
        return users;
    }


}
