package myforexhelp.realtime.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class ArticleTransferObject {
    @Id
    private Long id;
    private String title;
    private String description;
    }

