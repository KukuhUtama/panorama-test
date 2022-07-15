package org.com.panorama.repository;

import org.com.panorama.entity.RoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends PagingAndSortingRepository<RoleEntity,Long>{

}
