package md.miller1995.Dealership.repositories;

import md.miller1995.Dealership.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * This method create a custom query, that find/select a username of UserEntity from table "users_auth" after parameter/column "username"
     *
     * @author Anton Nirca
     * @since 10/05/2023
     *
     * @param username
     * @return UserEntity
     */
    Optional<UserEntity> findUserEntityByUsername(String username);
}
