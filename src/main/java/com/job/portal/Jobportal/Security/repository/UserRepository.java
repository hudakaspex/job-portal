package com.job.portal.Jobportal.Security.repository;

import com.job.portal.Jobportal.Security.models.UserPortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserPortal, Long> {
    @Query(
            value = "select * from user inner join party on user.info_id = party.id where party.email=:email", nativeQuery = true)
    Optional<UserPortal> findUserInfoByEmail(@Param("email") String email);
}
