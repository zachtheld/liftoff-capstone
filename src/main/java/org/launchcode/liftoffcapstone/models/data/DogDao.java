package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface DogDao extends CrudRepository<Dog, Integer> {
    public List<Dog> findByUserId(Integer user_id);
}
