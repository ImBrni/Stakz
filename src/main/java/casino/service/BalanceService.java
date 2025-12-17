package casino.service;

import casino.repository.AppUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceService {

    private final AppUserRepository userRepository;

    public BalanceService(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addBalance(Long userId, long delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("delta must be >= 0");
        }

        int updated = userRepository.addBalanceAtomic(userId, delta);
        if (updated == 0) {
            throw new EntityNotFoundException("User not found: " + userId);
        }
    }

    @Transactional
    public void subBalance(Long userId, long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }

        int updated = userRepository.subBalanceAtomic(userId, amount);
        if (updated == 0) {
            if (userRepository.existsById(userId)) {
                throw new IllegalStateException("Insufficient funds");
            }
            throw new EntityNotFoundException("User not found: " + userId);
        }
    }
}
