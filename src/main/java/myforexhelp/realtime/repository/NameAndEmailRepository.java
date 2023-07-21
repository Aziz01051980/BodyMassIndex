package myforexhelp.realtime.repository;

import myforexhelp.realtime.domain.NameAndEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameAndEmailRepository extends JpaRepository<NameAndEmail, Long> {

    @Query(value = "SELECT t.email FROM NameAndEmail t WHERE t.id IS NOT NULL")
    List<String> findAllMails();

}
