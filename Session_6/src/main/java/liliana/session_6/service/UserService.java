package liliana.session_6.service;

import liliana.session_6.dto.response.DataResponse;
import liliana.session_6.entity.User;
import liliana.session_6.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public DataResponse<List<User>> getAllUsers() {
        return DataResponse.<List<User>>builder().key("users").data(userRepository.findAll()).build();
    }

    // Lấy user theo ID
    public DataResponse<User> getUserById(Long id) {
        return DataResponse.<User>builder().key("users").data(userRepository.findById(id).orElse(null)).build();
    }


    public DataResponse<User> createUser(User user) {
        return DataResponse.<User>builder().key("users").data(userRepository.save(user)).build();
    }

    // Cập nhật user theo ID
    public DataResponse<User> updateUser(Long id, User updatedUser) {
        if (!userRepository.existsById(id)) {
            return DataResponse.<User>builder().key("users").data(null).build();
        }
        User existingUser = userRepository.findById(id).get();
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        return DataResponse.<User>builder().key("users").data(userRepository.save(existingUser)).build();
    }


    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return;
        }
        userRepository.deleteById(id);
    }
}

