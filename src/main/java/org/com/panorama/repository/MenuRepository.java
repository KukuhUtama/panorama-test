package org.com.panorama.repository;

import org.com.panorama.entity.MenuEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("menuRepository")
public interface MenuRepository extends PagingAndSortingRepository<MenuEntity,Long>{

}
