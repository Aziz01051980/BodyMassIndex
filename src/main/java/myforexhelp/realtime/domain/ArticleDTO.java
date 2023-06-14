package myforexhelp.realtime.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class ArticleDTO {
    @Id
    private Long id;
    private String title;

    public ArticleDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public ArticleDTO() {

    }


    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getFormattedData() {
        return id;
    }

    public String getFormattedData1() {
        return title;
    }
}
