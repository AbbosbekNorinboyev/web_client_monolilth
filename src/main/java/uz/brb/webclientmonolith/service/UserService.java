package uz.brb.webclientmonolith.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.brb.webclientmonolith.dto.AddressDto;
import uz.brb.webclientmonolith.dto.CompanyDto;
import uz.brb.webclientmonolith.dto.GeoDto;
import uz.brb.webclientmonolith.dto.UserDto;

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

    public Flux<UserDto> getUsersV2() {

        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/users")
                .retrieve()
                .bodyToFlux(UserDto.class)
                .map(userDto -> {
                    UserDto user = new UserDto();
                    user.setId(userDto.getId());
                    user.setName(userDto.getName());
                    user.setUsername(userDto.getUsername());
                    user.setEmail(userDto.getEmail());
                    user.setPhone(userDto.getPhone());
                    user.setWebsite(userDto.getWebsite());

                    if (userDto.getAddress() != null) {
                        AddressDto addressDto = new AddressDto();
                        addressDto.setStreet(userDto.getAddress().getStreet());
                        addressDto.setSuite(userDto.getAddress().getSuite());
                        addressDto.setCity(userDto.getAddress().getCity());
                        addressDto.setZipcode(userDto.getAddress().getZipcode());

                        if (userDto.getAddress().getGeo() != null) {
                            GeoDto geo = new GeoDto();
                            geo.setLat(userDto.getAddress().getGeo().getLat());
                            geo.setLng(userDto.getAddress().getGeo().getLng());

                            addressDto.setGeo(geo);
                        }

                        user.setAddress(addressDto);
                    }

                    if (userDto.getCompany() != null) {
                        CompanyDto companyDto = new CompanyDto();
                        companyDto.setName(userDto.getCompany().getName());
                        companyDto.setCatchPhrase(userDto.getCompany().getCatchPhrase());
                        companyDto.setBs(userDto.getCompany().getBs());

                        user.setCompany(companyDto);
                    }

                    return user;
                });
    }
}