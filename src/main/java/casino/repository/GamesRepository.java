package casino.repository;

import casino.model.Games;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface GamesRepository extends JpaRepository<Games, Long> {
    List<Games> findByPlayerId(Long playerId);
    Page<Games> findByPlayerId(Long playerId, Pageable pageable);

    List<Games> findByPlayerIdAndCreatedAtBetween(Long playerId, LocalDateTime start, LocalDateTime end);
    List<Games> findByPlayerIdAndBalanceDiffGreaterThan(Long playerId, Long minWinAmount);

}
