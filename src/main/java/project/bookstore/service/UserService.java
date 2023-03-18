package project.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.bookstore.dto.BookDTO;
import project.bookstore.dto.UserDTO;
import project.bookstore.repository.BookRepository;
import project.bookstore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserDTO> getAllUsers(){
        try {
            return userRepository.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }


    public UserDTO getUserById(Long id){
        Optional<UserDTO> userDTO = userRepository.findById(id);
        if(userDTO.isPresent()){
            return userDTO.get();
        }else{
            throw new EntityNotFoundException("User not found");
        }
    }

    public List<UserDTO> findByLastnameOrFirstname(String lastname, String firstname) {
        try{
            return userRepository.findByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(lastname, firstname);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }

}
