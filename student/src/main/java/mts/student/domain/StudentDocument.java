package mts.student.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "sr_student_document")
@Entity
public class StudentDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "document_date")
    private LocalDate documentDate;
    @Column(name = "expired_date")
    private LocalDate expiredDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;



}
