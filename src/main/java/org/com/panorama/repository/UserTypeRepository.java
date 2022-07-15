package org.com.panorama.repository;

import org.com.panorama.entity.UserTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository("userTypeRepository")
public interface UserTypeRepository extends PagingAndSortingRepository<UserTypeEntity,Long>{

}
