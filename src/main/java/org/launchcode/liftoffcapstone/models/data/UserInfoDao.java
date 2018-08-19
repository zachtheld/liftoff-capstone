package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserInfoDao extends CrudRepository<UserInfo, Integer> {
    public List<UserInfo> findByUserId (Integer user_id);
}
