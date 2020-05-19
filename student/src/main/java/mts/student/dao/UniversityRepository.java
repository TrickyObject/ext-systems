package mts.student.dao;

import mts.student.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository  extends JpaRepository<University, Long> {


}
