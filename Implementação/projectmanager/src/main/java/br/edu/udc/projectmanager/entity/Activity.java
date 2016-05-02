package br.edu.udc.projectmanager.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Activity extends AbstractEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2987952535923866536L;

	/*-------------------------------------------------------------------
	 *				 		     ATRIBUTES
	 *-------------------------------------------------------------------*/	
	/**
	 * 
	 */
	@NotNull
	@Column( nullable = true, length = 50 )
	private String name;
	
	/**
	 * 
	 */
	@Column( length = 200 )
	private String description;
	
	/**
	 * 
	 */
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private ActivityStatus status;
	/**
	 * 
	 */
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private ActivityType type;
	
	/**
	 * 
	 */
	@ManyToOne( optional = false, fetch = FetchType.EAGER )
	private User responsible;
	
	/**
	 * 
	 */
	@ManyToOne ( optional = false, fetch = FetchType.LAZY)
	private Project project;
	/**
	 * 
	 */
	@OneToMany ( cascade = CascadeType.REMOVE, mappedBy="activity", fetch = FetchType.EAGER )
	private Set<ActivityLog> activityLog = new HashSet<ActivityLog>();
	/**
	 * 
	 */
	@OneToMany ( cascade = CascadeType.REMOVE, mappedBy="activity", fetch = FetchType.EAGER )
	private Set<Annotation> annotations = new HashSet<Annotation>();
	/**
	 * 
	 */
	@ManyToOne ( optional = true, fetch = FetchType.EAGER )
	private Milestone milestone;
	/**
	 * 
	 */
	@NotNull
	@Column(nullable = false)
	private Calendar date;
	/**
	 * 
	 */
	@Column(nullable = false)
	private Long workTime;
	/**
	 * 
	 */
	@Column(nullable = false)
	private Long duration;
	/**
	 * 
	 */
	
	
	/*-------------------------------------------------------------------
	 *				 		     CONTRUCTOR
	 *-------------------------------------------------------------------*/	
	/**
	 * 
	 */
	public Activity()
	{
		super();
	}
	/**
	 * 
	 * @param id
	 */
	public Activity( Long id )
	{
		super( id );
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param status
	 * @param responsible
	 * @param date
	 * @param workTime
	 * @param duration
	 */
	public Activity(Long id, String name, String description, ActivityStatus status, User responsible, Calendar date, Long workTime, Long duration, ActivityType type)
	{
		super( id );
		this.name = name;
		this.description = description;
		this.status = status;
		this.responsible = responsible;
		this.date = date;
		this.workTime = workTime;
		this.duration = duration;
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((activityLog == null) ? 0 : activityLog.hashCode());
		result = prime * result + ((annotations == null) ? 0 : annotations.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((milestone == null) ? 0 : milestone.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((responsible == null) ? 0 : responsible.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((workTime == null) ? 0 : workTime.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (activityLog == null) {
			if (other.activityLog != null)
				return false;
		} else if (!activityLog.equals(other.activityLog))
			return false;
		if (annotations == null) {
			if (other.annotations != null)
				return false;
		} else if (!annotations.equals(other.annotations))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (milestone == null) {
			if (other.milestone != null)
				return false;
		} else if (!milestone.equals(other.milestone))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (responsible == null) {
			if (other.responsible != null)
				return false;
		} else if (!responsible.equals(other.responsible))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		if (workTime == null) {
			if (other.workTime != null)
				return false;
		} else if (!workTime.equals(other.workTime))
			return false;
		return true;
	}

	/*-------------------------------------------------------------------
	 *				 		     GETER'S AND SETER'S
	 *-------------------------------------------------------------------*/	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public ActivityStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ActivityStatus status) {
		this.status = status;
	}

	/**
	 * @return the responsible
	 */
	public User getResponsible() {
		return responsible;
	}

	/**
	 * @param responsible the responsible to set
	 */
	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the activityLog
	 */
	public Set<ActivityLog> getActivityLog() {
		return activityLog;
	}

	/**
	 * @param activityLog the activityLog to set
	 */
	public void setActivityLog(Set<ActivityLog> activityLog) {
		this.activityLog = activityLog;
	}

	/**
	 * @return the annotations
	 */
	public Set<Annotation> getAnnotations() {
		return annotations;
	}

	/**
	 * @param annotations the annotations to set
	 */
	public void setAnnotations(Set<Annotation> annotations) {
		this.annotations = annotations;
	}

	/**
	 * @return the milestone
	 */
	public Milestone getMilestone() {
		return milestone;
	}

	/**
	 * @param milestone the milestone to set
	 */
	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @return the workTime
	 */
	public Long getWorkTime() {
		return workTime;
	}

	/**
	 * @param workTime the workTime to set
	 */
	public void setWorkTime(Long workTime) {
		this.workTime = workTime;
	}

	/**
	 * @return the duration
	 */
	public Long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	/**
	 * @return the type
	 */
	public ActivityType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ActivityType type) {
		this.type = type;
	}
	

	

}
