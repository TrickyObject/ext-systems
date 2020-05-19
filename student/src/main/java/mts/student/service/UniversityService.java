package mts.student.service;

import mts.student.dao.UniversityRepository;
import mts.student.domain.University;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Transactional(readOnly = true)
    public List<University> findUniversities() {

        return universityRepository.findAll();
    }
}
