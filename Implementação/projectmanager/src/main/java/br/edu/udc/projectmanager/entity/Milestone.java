package br.edu.udc.projectmanager.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Milestone extends AbstractEntity {
	
	@NotNull
	@Column( nullable = false, unique = true, length = 50 )
	private String name;
	
	@Column ( length = 200 )
	private String notes;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar initialDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar finalDate;
	
//	@OneToMany( fetch = FetchType.LAZY )
//	private Set<Activity> activities = new HashSet<Activity>();
	
	@ManyToOne( optional = false, fetch = FetchType.LAZY )
	private Project project;

	public Milestone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Milestone(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((finalDate == null) ? 0 : finalDate.hashCode());
		result = prime * result
				+ ((initialDate == null) ? 0 : initialDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milestone other = (Milestone) obj;
		if (finalDate == null) {
			if (other.finalDate != null)
				return false;
		} else if (!finalDate.equals(other.finalDate))
			return false;
		if (initialDate == null) {
			if (other.initialDate != null)
				return false;
		} else if (!initialDate.equals(other.initialDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Calendar getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Calendar initialDate) {
		this.initialDate = initialDate;
	}

	public Calendar getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Calendar finalDate) {
		this.finalDate = finalDate;
	}

//	public Set<Activity> getActivities() {
//		return activities;
//	}
//
//	public void setActivities(Set<Activity> activities) {
//		this.activities = activities;
//	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
}
