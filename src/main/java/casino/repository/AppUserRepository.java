package casino.repository;

import casino.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findById(Long id);
    Optional<AppUser> findByUsername(String username);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(" update AppUser u set u.balance = u.balance + :amount where u.id = :userId ")
    int addBalanceAtomic(@Param("userId") Long userId, @Param("amount") long amount);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(" update AppUser u set u.balance = u.balance - :amount where u.id = :userId and u.balance >= :amount ")
    int subBalanceAtomic(@Param("userId") Long userId, @Param("amount") long amount);

    @Query(" select u.balance from AppUser u where u.id = :userId ")
    Optional<Long> findBalanceById(@Param("userId") Long userId);
}
