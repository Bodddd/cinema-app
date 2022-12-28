package cinema.service.mapper;

import cinema.dto.response.UserResponseDto;
import cinema.model.Role;
import cinema.model.User;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setRolesIds(user.getRoles().stream()
                .map(Role::getId)
                .collect(Collectors.toSet()));
        return responseDto;
    }
}
