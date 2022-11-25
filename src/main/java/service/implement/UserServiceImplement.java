package service.implement;

import entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Bu şekilde de injection yapabiliriz
public class UserServiceImplement implements UserService {

    private  final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreatedAt(new Date());
        user.setCreatedBy("Admin");
        return userRepository.save(user);
    }


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
      Optional<User> user = userRepository.findById(id);
      if (user.isPresent()){
          return user.get();
      }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> resultUser = userRepository.findById(id);

        if (resultUser.isPresent()){
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdateBy("Admin");

            return this.userRepository.save(resultUser.get());
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
