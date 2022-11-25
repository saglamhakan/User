package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User extends BaseEntity{
    @Id
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_gen", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "firs_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
