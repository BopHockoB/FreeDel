package ua.nure.freedel.user.role;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.freedel.user.User;

import java.util.List;


@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Role>> getAllRoles(){
        return new ResponseEntity<>(roleService.findAllRoles(), HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }

    @PostMapping("/remove-all-users-from-role/{roleId}")
    public Role removeAllUsersFromRole(@PathVariable Long roleId){
        return roleService.removeAllUserFromRole(roleId);
    }

    @PostMapping("/remove-user-from-role")
    public User removeUserFromRole(@RequestBody Long roleId,
                                   @RequestBody Long userId){
        return roleService.removeUserFromRole(userId, roleId);
    }

    @PostMapping("/assign-user-from-role")
    public User assignUserFromRole(@RequestBody Long roleId,
                                   @RequestBody Long userId){
        return roleService.assignUserToRole(userId, roleId);
    }
}
