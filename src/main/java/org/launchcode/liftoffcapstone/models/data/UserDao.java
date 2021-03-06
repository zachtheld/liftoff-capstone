package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    public List<User> findByEmail(String email);
}
