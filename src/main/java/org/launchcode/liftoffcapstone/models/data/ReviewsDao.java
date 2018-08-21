package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.Reviews;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ReviewsDao extends CrudRepository<Reviews, Integer> {
    public List<Reviews> findByUserId(Integer user_id);
}
