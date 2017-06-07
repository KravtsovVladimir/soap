package com.soap;

import com.soap.dto.Event;
import com.soap.dto.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class Repository {

    private List<User> users = new ArrayList<User>();
    private List<Event> events = new ArrayList<Event>();

    public Repository() {
        Event event1 = new Event("Event_1", "Some message bla-bla-bla");
        Event event2 = new Event("Event_2", "Other message 123");
        Event event3 = new Event("Event_3", "This is very important event!");

        events.add(event1);
        events.add(event2);
        events.add(event3);

        User user1 = new User(1, 17, "John", "john@email.com");
        user1.addEvent(event1);

        User user2 = new User(2, 34, "Oliver", "oliver@email.com");
        user2.addEvent(event2);
        user2.addEvent(event3);

        users.add(user1);
        users.add(user2);
    }

    public boolean save(User user) {
        try {
            users.add(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean remove(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUid() == id) {
                try {
                    users.remove(i);
                    return true;
                } catch (Exception ex) {
                    return false;
                }
            }
        }
        throw new NoSuchElementException("No user with this id");
    }

    public User getById(int id) {
        for (User user : users) {
            if (user.getUid() == id) {
                return user;
            }
        }
        throw new NoSuchElementException("No user with this id");
    }

    public List<User> getAll() {
        return users;
    }
}
