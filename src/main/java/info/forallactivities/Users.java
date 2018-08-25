package info.forallactivities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class Users {

	public Users(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public Users() {}

	@Id
	private long userid;
	@Column(name="name")
    private String name;
	@Column(name="password")
    private String password;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
