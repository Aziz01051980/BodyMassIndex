package health.bmi.repository;

import health.bmi.domain.BmiData;
import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface BmiDataRepository extends JpaRepository<BmiData, Long> {
    @Override
    <S extends BmiData> S save(S entity);

    @Query("SELECT MAX(b.personBMI) FROM BmiData b WHERE b.personName = :yourName")
    Double getBmiBypersonName(@Param("yourName") String name);


}
