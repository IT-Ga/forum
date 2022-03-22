package net.javaguildes.springboot.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Column(unique = true)
	private String username;
	private String password;
	@ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
	private Role role_id;
	@Column(nullable = false)
	private Boolean isblocked;
	private String name;
	private String address;
	private String phone;
	private String email;
	@Column(nullable = false, name = "birthday", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp birthday;
	@Column(nullable = false, name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdat;
	@Column(nullable = false, name = "deleted_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp deletedat;
	@Column(nullable = false, name = "updated_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedat;
	/////////
	public Account() {
		
	}
	public Account( String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public Account( String username, String password, Role role_id, Boolean is_blocked, String name,
			String address, String phone, String email, Timestamp birthday, Timestamp created_at, Timestamp deleted_at,
			Timestamp updated_at) {
		super();
		this.username = username;
		this.password = password;
		this.role_id = role_id;
		this.isblocked = is_blocked;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.createdat = created_at;
		this.deletedat = deleted_at;
		this.updatedat = updated_at;
	}
	
	/////////
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole_id() {
		return role_id;
	}
	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}
	public Boolean getIs_blocked() {
		return isblocked;
	}
	public void setIs_blocked(Boolean is_blocked) {
		this.isblocked = is_blocked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public Timestamp getCreated_at() {
		return createdat;
	}
	public void setCreated_at(Timestamp created_at) {
		this.createdat = created_at;
	}
	public Timestamp getDeleted_at() {
		return deletedat;
	}
	public void setDeleted_at(Timestamp deleted_at) {
		this.deletedat = deleted_at;
	}
	public Timestamp getUpdated_at() {
		return updatedat;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updatedat = updated_at;
	}
	
	/////////
	
}
