package dev.camargo.criptografia.service;

import dev.camargo.criptografia.domain.User;
import dev.camargo.criptografia.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository repository;
    
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User createUser(User user){
        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return repository.findById(id);
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }

    public User updateUser(Long id, User userAtualizado){
        User userExistente = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userExistente.setUserDocument(userAtualizado.getUserDocument());
        userExistente.setCreditCardToken(userAtualizado.getCreditCardToken());
        userExistente.setValue(userAtualizado.getValue());

        return repository.save(userExistente);
    }
}