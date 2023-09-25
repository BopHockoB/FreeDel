package ua.nure.freedel.user.role;

import ua.nure.freedel.user.User;

import java.util.List;

public interface IRoleService {

    List<Role> findAllRoles();

    Role createRole(Role role);

    void deleteRole(Long id);

    Role findById(Long id);

    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);

    User assignUserToRole(Long userId, Long roleId);

    Role removeAllUserFromRole(Long roleId);
}
