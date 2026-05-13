package uz.brb.webclientmonolith.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.brb.webclientmonolith.entity.UserEntity;

@Service
@RequiredArgsConstructor
public class UserService {

    private final WebClient webClient;

    public Mono<String> getUsersV1() {

        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/users")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Flux<UserEntity> getUsersV2() {

        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/users")
                .retrieve()
                .bodyToFlux(UserEntity.class);
    }
}