package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role admin = new Role();
        admin.setRoleName(Role.RoleName.ADMIN);
        Role user = new Role();
        user.setRoleName(Role.RoleName.USER);
        roleService.add(admin);
        roleService.add(user);

        User defaultUser = new User();
        defaultUser.setEmail("skrypnikbod@gmail.com");
        defaultUser.setPassword("?drowssap");
        defaultUser.setRoles(Set.of(user));

        User adminUser = new User();
        adminUser.setEmail("alice@gmail.com");
        adminUser.setPassword("adminADMIn");
        adminUser.setRoles(Set.of(admin));

        userService.add(adminUser);
        userService.add(defaultUser);
    }
}
