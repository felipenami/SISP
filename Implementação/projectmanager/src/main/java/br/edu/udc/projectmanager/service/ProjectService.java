package br.edu.udc.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.edu.udc.projectmanager.entity.Activity;
import br.edu.udc.projectmanager.entity.Project;
import br.edu.udc.projectmanager.entity.ProjectStatus;
import br.edu.udc.projectmanager.entity.User;
import br.edu.udc.projectmanager.repository.IActivityRepository;
import br.edu.udc.projectmanager.repository.IProjectRepository;
import br.edu.udc.projectmanager.repository.IUserRepository;

@Service
@Transactional
public class ProjectService {

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	@Autowired
	private IProjectRepository projectRepository;
	/**
	 * 
	 */
	@Autowired
	private IActivityRepository activityRepository;
	/**
	 * 
	 */
	@Autowired
	private IUserRepository userRepository;
	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/
	
	/**
	 * 
	 * @param project
	 * @return
	 */
	public Project insertProjeto(Project project)
	{
		
		project = projectRepository.saveAndFlush(project);
		
		return project;
	}
	/**
	 * 
	 * @param project
	 * @return
	 */
	public Project updateProject (Project project)
	{
		return this.projectRepository.save(project);
				
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Project findById (Long id)
	{
		return this.projectRepository.findOne(id);
	}
	/**
	 * 
	 * @return
	 */
	public List<Project> findAll()
	{
		
		return this.projectRepository.findAll();
	}
	
	public List<User> findAllUsers()
	{
		return this.userRepository.findAll();
	}
	/**
	 * 
	 * @param projectId
	 */
	public void removeProject ( Long projectId )
	{
		Assert.notNull( projectId, "Por favor informe o projeto a ser inserido." );
		
		this.projectRepository.delete( projectId );
	}
	/**
	 * 
	 * @param filter
	 * @param initialDate
	 * @param finalDate
	 * @param status
	 * @param pageable
	 * @return
	 */
//	public Page<Project> listProjectsByFilters(String filter, PageRequest pageable)
//	{
//		return this.projectRepository.listByFilters(filter, pageable);
//	}
	
	/**
	 * 
	 * @param projectId
	 * @param projectStatus
	 */
	public void updateProjectStatus ( Long projectId, ProjectStatus projectStatus )
	{
		Project project = this.projectRepository.findOne( projectId );
		
		project.setStatus( projectStatus );
		
		this.projectRepository.save( project );
	}
	/**
	 * 
	 * @param activity
	 * @return
	 */
	public Activity insertAtividade(Activity activity)
	{
		activity = activityRepository.save(activity);
		return activity;
	}
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public List<Activity> findActivityByProjectId(Long projectId)
	{
		return activityRepository.listActivityByproject(projectId);
	}
	
	
}
