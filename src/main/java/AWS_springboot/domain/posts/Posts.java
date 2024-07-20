package AWS_springboot.domain.posts;


import AWS_springboot.domain.BaseTimeEntity;
//import jakarta.persistence.*;//스프링3.0부터 javax->jakarta로 변경
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increase적용
    private Long id;
    @Column(length = 500,nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;
    private String author;
    @Builder
    public Posts(String title,String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;

    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }
}
