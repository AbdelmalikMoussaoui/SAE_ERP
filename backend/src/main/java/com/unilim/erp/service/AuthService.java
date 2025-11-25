package com.unilim.erp.service;

import com.unilim.erp.domain.UserRole;
import com.unilim.erp.domain.UserStatus;
import com.unilim.erp.dto.AuthRequest;
import com.unilim.erp.dto.RegistrationRequest;
import com.unilim.erp.entities.AppUser;
import com.unilim.erp.repositories.AppUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager; // Nécessaire pour le login

    public AuthService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Rôle : login(email, password) (renvoie un Token)
    public String login(AuthRequest request) {
        // 1. Authentification Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        // 2. Si l'authentification réussit, récupère l'utilisateur
        var user = appUserRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Email non trouvé après authentification"));

        // 3. Génère le Token JWT
        return jwtService.generateToken(user);
    }

    // Rôle : register(userDto) (crée un nouvel utilisateur)
    public AppUser register(RegistrationRequest request) {
        // Vérifie si l'utilisateur existe déjà
        if (appUserRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Cet email est déjà utilisé.");
        }

        // Création de l'entité AppUser
        var user = new AppUser();
        user.setEmail(request.email());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setDisplayName(request.displayName());
        user.setPhone(request.phone());
        user.setRole(request.role() != null ? request.role() : UserRole.ENSEIGNANT); // Role par défaut
        user.setStatus(UserStatus.ACTIVE); // Statut initial

        // Note: Le Department doit être géré si un ID est fourni dans le DTO

        return appUserRepository.save(user);
    }
}
