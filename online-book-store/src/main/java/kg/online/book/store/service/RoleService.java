package kg.online.book.store.service;

import kg.online.book.store.entity.Role;

import java.util.List;

public interface RoleService {
    Role create(Role role);
    Role deleteById(Long id);
    List<Role> getAll();
    Role getById(Long id);
}
