package com.cdev.reacthookscrudserver.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name="tutorials")

public class Tutorial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "nbpage")
	private Integer nbpage;

	@Column(name = "description")
	private String description;
	
	@Column(name = "auteur")
	private String auteur;

	@Column(name = "published", columnDefinition = "BOOLEAN")
	private boolean published;
	
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "dateEdit")
    Date dateEdit;
	
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    Date createdAt=new Date();
    
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "updatedAt")
    Date updatedAt;
    
    
    //@Temporal(TemporalType.DATE)
    //Date publicationDate;
 
    //@Temporal(TemporalType.TIME)
    //Date publicationTime;

	
	
	
	public Tutorial() {}
	

	public Tutorial(String title, Integer nbpage, String description, String auteur, boolean published, Date dateEdit) {
		super();
		this.title = title;
		this.nbpage = nbpage;
		this.description = description;
		this.auteur = auteur;
		this.published = published;
		this.dateEdit = dateEdit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	
	public Integer getNbpage() {
		return nbpage;
	}


	public void setNbpage(Integer nbpage) {
		this.nbpage = nbpage;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getDateEdit() {
		return dateEdit;
	}


	public void setDateEdit(Date dateEdit) {
		this.dateEdit = dateEdit;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	

}
