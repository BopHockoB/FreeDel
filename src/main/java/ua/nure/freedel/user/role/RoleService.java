package ua.nure.freedel.user.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nure.freedel.user.*;
import ua.nure.freedel.user.exception.RoleAlreadyExistException;
import ua.nure.freedel.user.exception.UserAlreadyExistException;
import ua.nure.freedel.user.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService{

    private final RoleRepository roleRepository;
    private final UserRepository userService;

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role role) {
        if (roleRepository.findByName(role.getName()).isPresent())
            throw new RoleAlreadyExistException("Role with name " + role.getName() + " already exists");
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        removeAllUserFromRole(id);
        roleRepository.deleteById(id);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).get();
    }

    @Override
    public User removeUserFromRole(Long userId, Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        Optional<User> user = userService.findById(userId);

        if (role.isPresent() &&
                role.get().getUsers().contains(user.get())) {
            role.get().removeUserFromRole(user.get());

            roleRepository.save(role.get());
            return user.get();
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public User assignUserToRole(Long userId, Long roleId) {
        Optional<User> user = userService.findById(userId);
        Optional<Role> role = roleRepository.findById(roleId);

        if (user.isPresent()
                && user.get().getRoles().contains(role.get())){
            throw new UserAlreadyExistException(
                    user.get().getFirstName()+ " is already assigned to the " + role.get().getName() +" role");
        }
        role.ifPresent(roleToAssign -> roleToAssign.assignUserToRole(user.get()));
        roleRepository.save(role.get());
        return user.get();
    }

    @Override
    public Role removeAllUserFromRole(Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        role.ifPresent(Role::removeAllUsersFromRole);
        return roleRepository.save(role.get());
    }
}
