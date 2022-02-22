package id.co.nds.springboot.maven.crud.springbootwithreact;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="course")
public class NewCourse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "descriptions")
	private String description;
	
	public NewCourse() {
		
	}
	
	public NewCourse(Long id, String username, String description) {
		this.setId(id);
		this.username = username;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long idCounter) {
		this.id = idCounter;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;	
	}
}
