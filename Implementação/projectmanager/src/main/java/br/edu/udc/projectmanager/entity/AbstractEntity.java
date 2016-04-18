package br.edu.udc.projectmanager.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;
	
	/**
	 * 
	 */
	@PrePersist
	protected void refreshCreated()
	{
		if ( created == null )
		{
			this.created = Calendar.getInstance();
		}
	}

	/**
	 * 
	 */
	@PreUpdate
	protected void refreshUpdated()
	{
		this.refreshCreated();
		this.updated = Calendar.getInstance();
	}
	
	/**
	 * 
	 */
	public AbstractEntity()
	{
		super ();
	}
	
	/**
	 * 
	 * @param id
	 */
	public AbstractEntity(Long id) {
		super();
		this.id = id;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public Calendar getCreated() {
		return created;
	}
	
	/**
	 * 
	 * @param created
	 */
	public void setCreated(Calendar created) {
		this.created = created;
	}
	
	/**
	 * 
	 * @return
	 */
	public Calendar getUpdated() {
		return updated;
	}
	
	/**
	 * 
	 * @param updated
	 */
	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}
}
