package br.edu.udc.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.edu.udc.projectmanager.entity.Project;
import br.edu.udc.projectmanager.entity.ProjectStatus;
import br.edu.udc.projectmanager.entity.User;
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
		Assert.notNull( project.getName(), "O nome do projeto não poder ser nulo." );
		Assert.notNull( project.getInitialDate(), "Campo data inicial não pode ser nulo." );
		Assert.notNull( project.getFinalDate(), "Campo data final não pode ser nulo." );
		Assert.notNull( project.getProjectManager(), "Por favor escolha um gerente de projeto." );
		Assert.isNull( project.getId(), "O projeto já esta cadastrado." );
		
		
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
	 * @param filter
	 * @param initialDate
	 * @param finalDate
	 * @param status
	 * @param pageable
	 * @return
	 */
//	public Page<Project> listProjectsByFilters(String filter, Calendar initialDate, Calendar finalDate, ProjectStatus status, PageRequest pageable)
//	{
//		return this.projectRepository.listByFilters(filter, initialDate, finalDate, status, pageable);
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
	
}
