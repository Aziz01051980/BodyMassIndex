package health.bmi.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity
@Table(name = "bmi_seq", schema = "bodymassindex")
public class BmiData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "person_name")
        private String personName;

        @Column(name = "person_mail")
        private String personMail;

        @Column(name = "person_weight")
        private double personWeight;

        @Column(name = "person_Height")
        private double personHeight;

        @Column(name = "person_bmi")
        private double personBMI;
    }

