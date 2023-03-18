package project.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bookstore.dto.UserDTO;
import project.bookstore.service.BorrowingCardService;
import project.bookstore.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowingCardService borrowingCardService;

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping("/search")
    public ResponseEntity searchUser(@RequestParam(required = false) String lastname, @RequestParam(required = false) String firstname){
        return ResponseEntity.ok().body(userService.findByLastnameOrFirstname(lastname, firstname));
    }

    @GetMapping("/{id}/borrowingcards")
    public ResponseEntity listBorrowingcardsUser(@PathVariable Long id){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok().body(borrowingCardService.findByUserId(userDTO));
    }
}
