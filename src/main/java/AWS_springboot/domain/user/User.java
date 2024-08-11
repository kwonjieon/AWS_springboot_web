package AWS_springboot.domain.user;

import AWS_springboot.domain.BaseTimeEntity;
//import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column
    private String picture;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name,String email,String picture,Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }
    public User update(String name,String picture){
        this.name=name;
        this.picture=picture;
        return this;
    }
    public String getRoleKey(){
        return this.role.getKey();
    }
}