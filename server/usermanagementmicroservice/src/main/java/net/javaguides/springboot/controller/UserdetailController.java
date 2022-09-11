package net.javaguides.springboot.controller;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Userdetail;
import net.javaguides.springboot.repository.UserdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserdetailController {

    @Autowired
    private UserdetailRepository userdetailRepository;


    @GetMapping("/userdetail/{password}")
    public ResponseEntity<Userdetail> checkUser(@PathVariable String password) {
        System.out.println(password);
        Userdetail userdetail = userdetailRepository.findById(password)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with password :" + password));
        return ResponseEntity.ok(userdetail);
    }


}
