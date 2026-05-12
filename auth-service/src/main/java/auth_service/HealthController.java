package auth_service;

import auth_service.DTOs.LoginRequest;
import auth_service.DTOs.RegisterRequest;
import auth_service.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class HealthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/")
    public ResponseEntity<?> register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @GetMapping("/")
    public String check() {
        return "success running";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/profile")
    public String profile(Authentication auth) {
        return auth.getName();
    }


    //extra
        @GetMapping("/{id}")
        public String pass(@PathVariable int id){
        return authService.getName(id);
        }
}