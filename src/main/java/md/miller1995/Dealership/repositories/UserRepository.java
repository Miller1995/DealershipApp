package md.miller1995.Dealership.repositories;

import md.miller1995.Dealership.models.entities.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserAuthEntity, Long> {

    /**
     * This method create a custom query, that find/select a username of UserAuthEntity from table "users_auth" after parameter/column "username"
     *
     * @author Anton Nirca
     * @since 10/05/2023
     *
     * @param username
     * @return UserAuthEntity
     */
    Optional<UserAuthEntity> findUserAuthEntityByUsername(String username);
}