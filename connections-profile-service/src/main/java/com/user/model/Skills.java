package com.user.model;

<<<<<<< HEAD
public enum Skills {
    PYTHON, JAVA, NODEJS, REACTJS, ANGULAR, AWS, DATAANALYSIS, ANSYS, SOLIDWORKS, JUNIT, MOCKITO, SPRING,
    SPRINGBOOT, AUTOCAD, CATIA, CPP, C, GIT, MYSQL, KUBERNATES, DOTNET, JAVASCRIPT, CLOUDCOMPUTING, AZURE, GCP,
    ML, AI, SMM, SEO, SEM, CYBERSECURITY, ADWORDS, LINUX, MONGODB, UX, UI, SQLITE, POSTGRESQL, POSTMAN, HTML, CSS,
    SELENIUM, DEVOPS, GOOGLING, MSOFFICE, LIBREOFFICE, TROUBLESHOOTING, NETWORKING, WORDPRESS, FLASK, HIBERNATE, PHOTOSHOP, APACHE, PERL, XML, SWIFT, BLOCKCHAIN,
    PHP
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

public class Skills {
    @Id
    @GeneratedValue(generator = "skills_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="skills_seq",sequenceName = "skills_sequence",initialValue = 101,allocationSize = 1)
    @Column(name = "skillsid")
    private Integer skillsId;
    private String skillName;

    public Skills(String skillName) {
        this.skillName = skillName;
    }
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
}
