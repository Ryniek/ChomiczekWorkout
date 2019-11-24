package pl.rynski.chomiczek_workout.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public UserRole() {
    }

    public UserRole(String name, Set<User> users) {
        this.role = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return role;
    }

    public void setName(String name) {
        this.role = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + role + '\'' +
                ", users=" + users +
                '}';
    }
}
