package md.miller1995.Dealership.services.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import md.miller1995.Dealership.models.dto.UserAuthDTO;
import md.miller1995.Dealership.models.entities.UserAuthEntity;
import md.miller1995.Dealership.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void registerUser(UserAuthDTO userAuthDTO) {
        userAuthDTO.setUserPassword(passwordEncoder.encode(userAuthDTO.getUserPassword()));
        UserAuthEntity userAuthEntity = convertUserAuhtDTOToUserAuthEntity(userAuthDTO);
        userAuthEntity.setUserRole("ROLE_USER");
        userRepository.save(userAuthEntity);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateUser(UserAuthEntity userAuthEntity) {
        //TODO
    }

    private UserAuthEntity convertUserAuhtDTOToUserAuthEntity(UserAuthDTO userAuthDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.convertValue(userAuthDTO, UserAuthEntity.class);
    }

}