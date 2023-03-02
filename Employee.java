package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
@Entity
@Table(name="emp1")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(name="emp_name")
	private String name;
	@Column
	private String city;
	@OneToOne(cascade=CascadeType.ALL)
	private Adresss adress;
		public Adresss getAdress() {
		return adress;
	}
	public void setAdress(Adresss adress) {
		this.adress = adress;
	}
	//@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	//private List <Adresss>adress;
	
	//public List<Adresss> getAdress() {
		//return adress;
	//}
	//public void setAdress(List<Adresss> adress) {
		//this.adress = adress;
//	}
	public Employee( String name, String city) {
		super();
	
		this.name = name;
		this.city = city;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
