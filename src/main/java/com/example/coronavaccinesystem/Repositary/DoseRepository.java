package com.example.coronavaccinesystem.Repositary;

import com.example.coronavaccinesystem.Model.Dose;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
