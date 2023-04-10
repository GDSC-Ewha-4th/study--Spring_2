package hellojpa;


import javax.persistence.*;

@Entity
@TableGenerator(name ="Member_seq_generator",
                table= "member_seq",
                 pkColumnValue =  "member_seq" , allocationSize = 1
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "Member_seq_generator")
    private Long id;

    @Column(name="name", nullable=false)
    private String username;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
