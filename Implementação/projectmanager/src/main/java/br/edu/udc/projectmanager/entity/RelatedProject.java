package br.edu.udc.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

//TODO!
@Entity
public class RelatedProject extends AbstractEntity {

	@NotNull
	@ManyToOne ( fetch = FetchType.EAGER )
	private Project project;
	
	@NotNull
	@ManyToOne ( fetch = FetchType.EAGER )
	private Project relatedProject;
	
	@Column( nullable=false )
	@Enumerated(EnumType.ORDINAL)
	private RelatedProjectType relatedType;

	public RelatedProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatedProject(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result
				+ ((relatedProject == null) ? 0 : relatedProject.hashCode());
		result = prime * result
				+ ((relatedType == null) ? 0 : relatedType.hashCode());
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
		RelatedProject other = (RelatedProject) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (relatedProject == null) {
			if (other.relatedProject != null)
				return false;
		} else if (!relatedProject.equals(other.relatedProject))
			return false;
		if (relatedType != other.relatedType)
			return false;
		return true;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getRelatedProject() {
		return relatedProject;
	}

	public void setRelatedProject(Project relatedProject) {
		this.relatedProject = relatedProject;
	}

	public RelatedProjectType getRelatedType() {
		return relatedType;
	}

	public void setRelatedType(RelatedProjectType relatedType) {
		this.relatedType = relatedType;
	}
	
	
}
