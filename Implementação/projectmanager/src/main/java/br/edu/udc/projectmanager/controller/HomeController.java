package br.edu.udc.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.udc.projectmanager.entity.Activity;
import br.edu.udc.projectmanager.entity.Project;
import br.edu.udc.projectmanager.entity.User;
import br.edu.udc.projectmanager.service.ProjectService;

@Controller
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView menu()
	{
		return new ModelAndView("/index.html");
	}
	
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/		
	/**
	 * 
	 */
	@Autowired
	private ProjectService projectService;
	/**
	 * 
	 */
	/*-------------------------------------------------------------------
	 *				 		     PROJECT
	 *-------------------------------------------------------------------*/	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/projectList")
	public List<Project> projectList () {
		
		return projectService.findAll();
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/UserList")
	public List<User> userList () {
		
		return projectService.findAllUsers();
	}
	/**
	 * 
	 * @param project
	 * @return
	 */
	@RequestMapping("/projectSave")
	public Project save (@RequestBody Project project){
		
		return projectService.insertProjeto(project);
	}
	/**
	 * 
	 * @param project
	 * @return
	 */
	@RequestMapping("/activitySave")
	public Activity save (@RequestBody Activity activity){
		
		return projectService.insertAtividade(activity);
	}
	/**
	 * 
	 */
	@RequestMapping("/projectFindById")
	public Project findById (@RequestBody Long id){
		
		return projectService.findById(id);
	}
	/**
	 * 
	 * @param project
	 * @return
	 */
	@RequestMapping("/updateProject")
	public Project updateProject (@RequestBody Project project)
	{
		return projectService.updateProject(project);
	}
	/**
	 * 
	 * @param filter
	 * @param pageable
	 * @return
	 */
	@RequestMapping("/deleteProject")
	public void deleteProject(@RequestBody Long projectId)
	{
		 projectService.removeProject(projectId);;
	}
	
	/*-------------------------------------------------------------------
	 *				 		     ACTIVITY
	 *-------------------------------------------------------------------*/
	
	@RequestMapping("/findActivityByProjectId")
	public List<Activity> findActivityByProjectId (@RequestBody Long projectId)
	{
		return projectService.findActivityByProjectId(projectId);
	}
	
	
}

