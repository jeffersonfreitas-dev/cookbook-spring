package dev.jeffersonfreitas.restapicookbok.service.impl;

import dev.jeffersonfreitas.restapicookbok.dto.user.UserRequest;
import dev.jeffersonfreitas.restapicookbok.dto.user.UserResponse;
import dev.jeffersonfreitas.restapicookbok.exceptions.ResourceNotFoundException;
import dev.jeffersonfreitas.restapicookbok.mapper.UserMapper;
import dev.jeffersonfreitas.restapicookbok.model.User;
import dev.jeffersonfreitas.restapicookbok.repository.UserRepository;
import dev.jeffersonfreitas.restapicookbok.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;

    @Override
    @Transactional
    public UserResponse create(@NonNull UserRequest request) {
        User entity = UserMapper.toEntity(request);
        entity = repository.save(entity);
        return UserMapper.toResponse(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        Set<GrantedAuthority> granted = new HashSet<>();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), granted);
    }
}
