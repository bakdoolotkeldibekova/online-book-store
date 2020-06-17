package kg.online.book.store.controller;

import kg.online.book.store.dto.UserAccountAuthDTO;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.service.UserAccountService;
import kg.online.book.store.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/hello")
    public String sayHello(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @PostMapping("/registration")
    public UserAccount create(@RequestBody UserAccount userAccount) {
        return userAccountService.create(userAccount);
    }

    @PostMapping("/auth")
    public String getToken(@RequestBody UserAccountAuthDTO userAccountAuthDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAccountAuthDTO.getLogin(), userAccountAuthDTO.getPassword()));
        } catch (Exception e){
            throw new Exception("Auth failed");
        }
        return jwtUtil.generateToken(userAccountAuthDTO.getLogin());
    }
}
