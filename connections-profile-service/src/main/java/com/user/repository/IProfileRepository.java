package com.user.repository;

import com.user.exceptions.ProfileNotFoundException;
import com.user.model.OpenTo;
import com.user.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Integer> {

    @Query("from Profile p where p.name like ?1%")
    List<Profile> findByName(String name) throws ProfileNotFoundException;

    @Query("from Profile p where p.bio like %?1%")
    List<Profile> findByBio(String bio) throws ProfileNotFoundException;

    @Query("from Profile p inner join p.profileDetails d where d.openTo=?1")
    List<Profile> findByStatus(OpenTo openTo) throws ProfileNotFoundException;

    @Query("from Profile p inner join p.profileDetails d where d.qualification like %?1%")
    List<Profile> findByQualification(String qualification) throws ProfileNotFoundException;

    @Query("from Profile p inner join p.profileDetails d where d.experience=?1")
    List<Profile> findByExperience(int experience) throws ProfileNotFoundException;

    @Query("from Profile p inner join p.profileDetails d inner join d.skills s where s.skillName=?1")
    List<Profile> findBySkills(String skillName) throws ProfileNotFoundException;

    @Query("from Profile p inner join p.profileDetails d inner join d.certifications c where c.certificationName=?1")
    List<Profile> findByCertifications(String certificationName) throws ProfileNotFoundException;

    @Query("from Profile p inner join p.profileDetails d inner join d.skills s inner join d.certifications c where s.skillName=?1 and c.certificationName=?2")
    List<Profile> findByCertifiedSkills(String skillName, String certificationName) throws ProfileNotFoundException;
}
