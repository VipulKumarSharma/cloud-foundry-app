package io.exploretheweb.cloudfoundryapp.repository;

import io.exploretheweb.cloudfoundryapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    @Transactional
    List<User> deleteByName(String name);

}
