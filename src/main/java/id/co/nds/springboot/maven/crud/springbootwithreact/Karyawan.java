package id.co.nds.springboot.maven.crud.springbootwithreact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "karyawan")
public class Karyawan implements Serializable{

	@Id
	@Column(name = "nik")
	private String nik;
	@Column(name = "username")
	private String username;
	@Column(name = "descriptions")
	private String descriptions;
	public Karyawan() {
		super();
		
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
}
