package org.com.panorama.repository;

import org.com.panorama.entity.RoleMenuEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("roleMenuRepository")
public interface RoleMenuRepository extends PagingAndSortingRepository<RoleMenuEntity,Long> {

}
