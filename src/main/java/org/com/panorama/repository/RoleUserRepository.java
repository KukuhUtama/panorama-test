package org.com.panorama.repository;

import org.com.panorama.entity.RoleUserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("roleUserRepository")
public interface RoleUserRepository extends PagingAndSortingRepository<RoleUserEntity,Long>{

}
