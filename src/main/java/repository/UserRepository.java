package repository;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // JpaRepositoryde olmayan istekleri buraya bu şekilde yazarız.
  //  User findByFirstName(String firstName);
    //User findByFirstNameAndLastName(String firstName, String LastName);
}
