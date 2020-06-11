package kg.online.book.store.service;

import kg.online.book.store.dto.RoleDTO;
import kg.online.book.store.entity.Role;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserAccountService userAccountService;

    @Override
    public Role create(RoleDTO roleDTO) {
        UserAccount userAccount = userAccountService.getById(roleDTO.getUserAccountId());
        if(userAccount != null){
            Role role = new Role();
            role.setRoleName(roleDTO.getRoleName());
            role.setUserAccount(userAccount);
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public Role deleteById(Long id) {
        Role role = getById(id);
        roleRepository.deleteById(id);
        return role;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
