package uz.brb.webclientmonolith.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.brb.webclientmonolith.dto.UserDto;
import uz.brb.webclientmonolith.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/v1")
    public Mono<String> getUsersV1() {
        return userService.getUsersV1();
    }

    @GetMapping("/v2")
    public Flux<UserDto> getUsersV2() {
        return userService.getUsersV2();
    }
}
