package com.startup_app.repos;

import com.startup_app.domain.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PitchRepository extends JpaRepository<Pitch, Long> {
}
