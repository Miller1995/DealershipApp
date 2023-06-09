package md.miller1995.Dealership.services.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import md.miller1995.Dealership.models.dto.auth.UserAuthDTO;
import md.miller1995.Dealership.models.dto.auth.UserRegisterDTO;
import md.miller1995.Dealership.models.entities.UserAuthEntity;
import md.miller1995.Dealership.repositories.UserRepository;
import md.miller1995.Dealership.securities.JWTUtil;
import md.miller1995.Dealership.utils.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final ObjectMapper objectMapper;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTUtil jwtUtil, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public UserRegisterDTO register(@NonNull UserRegisterDTO userRegisterDTO) {
        var user = UserRegisterDTO.builder()
                .username(userRegisterDTO.getUsername())
                .dateOfBirth(userRegisterDTO.getDateOfBirth())
                .email(userRegisterDTO.getEmail())
                .userPassword(passwordEncoder.encode(userRegisterDTO.getUserPassword()))
                .build();

        UserAuthEntity userAuthEntity = convertUserRegisterDTOToUserAuthEntity(user);
        userAuthEntity.setUserRole("ROLE_USER");
        UserAuthEntity userAuthEntitySaved =  userRepository.save(userAuthEntity);
        UserRegisterDTO userRegisterReturn = convertUserAuthEntityToUserRegisterDTO(userAuthEntitySaved);
        return userRegisterReturn;
    }

    @Override
    public AuthResponse authenticate(@NonNull UserAuthDTO userAuthDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuthDTO.getUsername(),
                        userAuthDTO.getUserPassword())
        );

        var user = userRepository.findUserAuthEntityByUsername(userAuthDTO.getUsername()).orElseThrow();

        String jwtToken = jwtUtil.generateToken(user.getUsername());

        return AuthResponse.builder()
                .jwtToken(jwtToken)
                .build();
    }

//    public Map<String, String> performLogin(@RequestBody UserAuthDTO authDTO){
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getUserPassword());
//
//        try {
//            authenticationManager.authenticate(authenticationToken);
//        } catch (BadCredentialsException exception) {
//            return Map.of("message", "Incorrect credentials!");
//        }
//
//        String token = jwtUtil.generateToken(authDTO.getUsername());
//        return Map.of("jwt-token", token);
//    }

    private UserAuthEntity convertUserRegisterDTOToUserAuthEntity(UserRegisterDTO userRegisterDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.convertValue(userRegisterDTO, UserAuthEntity.class);
    }

    private UserRegisterDTO convertUserAuthEntityToUserRegisterDTO(UserAuthEntity userAuthEntity){
        return objectMapper.convertValue(userAuthEntity, UserRegisterDTO.class);
    }
}
