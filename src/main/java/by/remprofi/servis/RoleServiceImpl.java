package by.remprofi.servis;

import by.remprofi.domain.Role;
import by.remprofi.repository.RoleRepository;
import by.remprofi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    @Override
    public Role findOne(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(Role object) {
        return null;
    }

    @Override
    public Role update(Role object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Role> getUserAuthorities(Long userId) {
        return userRepository.getUserAuthorities(userId);
    }
}
