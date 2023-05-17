package md.miller1995.Dealership.services.users;

import md.miller1995.Dealership.models.dto.UserAuthDTO;
import md.miller1995.Dealership.models.entities.UserAuthEntity;

public interface UserService {

    /**
     * This method is used to register a new user in the database
     *
     * @author Anton Nirca
     * @since  12/05/2023
     *
     * @param userAuthDTO
     */
    void registerUser(UserAuthDTO userAuthDTO);

    /**
     * This method is used to update a user in the database
     *
     * @author Anton Nirca
     * @since  12/05/2023
     *
     * @param userAuthEntity
     */
    void updateUser(UserAuthEntity userAuthEntity);
}
