package com.unilim.erp.service;

import com.unilim.erp.domain.UserStatus;
import com.unilim.erp.entities.AppUser;
import com.unilim.erp.repositories.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    // Rôle : getAllUsers()
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    // Rôle : updateUserStatus(id, status)
    @Transactional
    public AppUser updateUserStatus(UUID id, UserStatus status) {
        return appUserRepository.findById(id)
                .map(user -> {
                    user.setStatus(status);
                    return appUserRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));
    }

    // Rôle : updateProfile(...)
    // Cette implémentation est simplifiée et gère le téléphone et l'affichage (display name)
    @Transactional
    public AppUser updateProfile(UUID id, String displayName, String phone) {
        return appUserRepository.findById(id)
                .map(user -> {
                    if (displayName != null) {
                        user.setDisplayName(displayName);
                    }
                    if (phone != null) {
                        user.setPhone(phone);
                    }
                    // Vous pouvez ajouter ici la logique pour changer le mot de passe (nécessite le PasswordEncoder)
                    return appUserRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));
    }

    // Méthode de support
    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }
}
