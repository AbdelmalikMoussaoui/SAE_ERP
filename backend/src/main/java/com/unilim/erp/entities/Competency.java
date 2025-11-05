package com.unilim.erp.entities;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

// --- IMPORT CORRIGÉ ---
// PAS org.hibernate.mapping.Set
import java.util.Set;
// ---

@Getter
@Setter
@Entity
@Table(name = "competency")
public class Competency {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, length = 50)
    private String code;

    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "competencies", fetch = FetchType.LAZY)
    private Set<ResourceSheet> resourceSheets = new LinkedHashSet<>();

    public Competency() {
    }

    public Competency(String code, String title) {
        this.code = code;
        this.title = title;
    }
}
