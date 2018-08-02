package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
