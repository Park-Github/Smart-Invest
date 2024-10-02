package poe.spring.domain.portfolio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poe.spring.domain.portfolio.model.entity.Portfolio;

import java.util.Optional;

public interface PortfolioRepo extends JpaRepository<Portfolio, Long> {
    Optional<Portfolio> findByName(String name);
}
