package md.miller1995.Dealership.services.auth;

import md.miller1995.Dealership.models.dto.auth.UserAuthDTO;
import md.miller1995.Dealership.models.dto.auth.UserRegisterDTO;
import md.miller1995.Dealership.utils.AuthResponse;

public interface AuthService {

    /**
     * This method is used to register a new user in the database
     *
     * @author Anton Nirca
     * @since  21/05/2023
     *
     * @param userRegisterDTO
     */
    UserRegisterDTO register(UserRegisterDTO userRegisterDTO);

    /**
     * This method is used for authenticate a user and return the jwt-token for this user
     *
     * @author Anton Nirca
     * @since  21/05/2023
     *
     * @param userAuthDTO
     */
    AuthResponse authenticate(UserAuthDTO userAuthDTO);
}
