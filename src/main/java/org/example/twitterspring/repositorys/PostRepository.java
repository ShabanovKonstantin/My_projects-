package org.example.twitterspring.repositorys;

import org.example.twitterspring.entity.PostEntity;
import org.example.twitterspring.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends
        JpaRepository<PostEntity, Long>,
        JpaSpecificationExecutor<PostEntity> {

    List<PostEntity> findPostEntitiesByAuthor_Id(Long id);

    PostEntity findPostEntityById(Long id);

    @Query(value = "select pe from PostEntity pe where cast(pe.tags as string) like concat('%', :tag, '%')")
    List<PostEntity> getPostEntitiesByTag(@Param(value = "tag") String tag);

    List<PostEntity> findPostEntitiesByAuthor_Login(String author);

    List<PostEntity> findPostEntitiesByAuthor_UserType(UserType userType);
}
