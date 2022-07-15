package org.com.panorama.repository;

import java.util.List;

import org.com.panorama.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	@Query(value = "select u from UserEntity u where u.userTypeId.id=:parentId")
	List<UserEntity> getByUserTypeId(@Param("parentId") Long parentId);
	
	@Query(value = "select u from UserEntity u where u.masterId.id=:parentId")
	List<UserEntity> getByUserMasterId(@Param("parentId") Long parentId);
	
	@Query(value = "select u from UserEntity u where u.name =:username")
	UserEntity loadByUsername(@Param("username") String username);

}
