package com.user.model;

<<<<<<< HEAD
public enum Certifications {
    AGILE, ORACLE, AWS, IRC,MICROSOFT,CLOUDCOMPUTING,
    GCP,IBM,PALO,SALESFORCE,PEGA,REDHAT,SCRUM,
    CITRIX,CHECKPOINT,DELLEMC,HPE,AZURE,ADOBE
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Certifications {
    @Id
    @GeneratedValue(generator = "certification_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="certification_seq",sequenceName = "certification_sequence",initialValue = 101,allocationSize = 1)
    @Column(name = "certificationsid")
    private Integer certificationsId;
    private String certificationName;

    public Certifications(String certificationName) {
        this.certificationName = certificationName;
    }
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
}
