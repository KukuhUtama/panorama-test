package org.com.panorama.repository;

import org.com.panorama.entity.MasterEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("masterRepository")
public interface MasterRepository extends PagingAndSortingRepository<MasterEntity,Long> {

}
