package org.example.perviyrazvsegdabolno.Service;

import org.example.perviyrazvsegdabolno.Entity.User;
import org.example.perviyrazvsegdabolno.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Создаем USER
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //Ищем в БД пользователя по id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    //Ищем пользователя по email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //Обновляем пользователя по id
    public User UpdateUser(Long id, String name, String email) {
        Optional<User> userOptional =userRepository.findById(id);
        if (userOptional.isPresent()) {
           User user = userOptional.get();
           user.setName(name);
           user.setEmail(email);
           return userRepository.save(user);
        }
        else {
            return null;
        }
    }


    //Удаляем пользователя (нужно переделать на состояние метки удаления)
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
