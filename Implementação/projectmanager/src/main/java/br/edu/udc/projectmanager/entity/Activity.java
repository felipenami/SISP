package br.edu.udc.projectmanager.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Activity extends AbstractEntity {
	
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
	private boolean status;
	
	/**
	 * 
	 */
	@ManyToOne( optional = true, fetch = FetchType.EAGER )
	private User owner;
	
	/**
	 * 
	 */
	@ManyToOne ( optional = false, fetch = FetchType.LAZY )
	private Project project;
	/**
	 * 
	 */
	@OneToMany ( cascade = CascadeType.REMOVE, mappedBy="activity", fetch = FetchType.EAGER)
	private Set<ActivityLog> activityLog = new HashSet<ActivityLog>();
	/**
	 * 
	 */
	@OneToMany ( cascade = CascadeType.REMOVE, mappedBy="activity", fetch = FetchType.EAGER)
	private Set<Annotation> annotations = new HashSet<Annotation>();
	/**
	 * 
	 */
	@ManyToOne ( optional = true, fetch = FetchType.EAGER )
	private Milestone milestone;
	
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
	 * @param ownerId
	 * @param ownerName
	 * @param projectId
	 * @param projectName
	 */
	public Activity ( Long id, String name, String description, Boolean status, Long ownerId, String ownerName, Long projectId, String projectName )
	{
		 super ( id );
		 this.name = name;
		 this.description = description;
		 this.status = status;

		 User user = new User();
		 user.setId( ownerId );
		 user.setName( ownerName );
		 
		 Project project = new Project ();
		 project.setId( projectId );
		 project.setName( projectName );
		 
		 this.setProject( project );
		 this.setOwner( user );
	}
	
	public Activity ( Long id, String name, String description, Boolean status, User owner,  String milestoneName, Long milestoneId, Calendar milestoneFinalDate)
	{   
		 super ( id );
		 this.name = name;
		 this.description = description;
		 this.status = status;
		 
		 Milestone milestone = new Milestone();
		 milestone.setName(milestoneName);
		 milestone.setId(milestoneId);
		 milestone.setFinalDate(milestoneFinalDate);
		 
		 this.setMilestone(milestone);
//		 this.setProject( project );
		 this.setOwner( owner );
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Milestone getMilestone() {
		return milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	public Set<ActivityLog> getActivityLog() {
		return activityLog;
	}

	public void setActivityLog(Set<ActivityLog> activityLog) {
		this.activityLog = activityLog;
	}

	public Set<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Set<Annotation> annotations) {
		this.annotations = annotations;
	}
	
	

}
