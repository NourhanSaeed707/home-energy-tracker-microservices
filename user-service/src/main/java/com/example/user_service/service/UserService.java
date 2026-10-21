package com.example.user_service.service;
import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto){
        log.info("Creating user {}", userDto);
        final User createdUser = User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .alerting(userDto.getAlerting())
                .energyAlertingThreshold(userDto.getEnergyAlertingThreshold())
                .build();
        User saved = userRepository.save(createdUser);
        return toDto(saved);
    }

    public UserDto getUserById(Long id) {
        log.info("Retrieving user by id {}", id);
        return userRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    private UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .address(user.getAddress())
                .alerting(user.getAlerting())
                .energyAlertingThreshold(user.getEnergyAlertingThreshold())
                .build();
    }


}
