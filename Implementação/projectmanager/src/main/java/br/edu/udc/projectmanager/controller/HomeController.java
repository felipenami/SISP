package br.edu.udc.projectmanager.controller;

import java.util.List;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
//	@RequestMapping(value = "/listByFilters", method = RequestMethod.GET)
//	public Page<Project> listByFilters( String filter, @PathVariable("pageable") PageRequest pageable)
//	{
//		return projectService.listProjectsByFilters(filter, pageable);
//	}
	
	/*-------------------------------------------------------------------
	 *				 		     ACTIVITY
	 *-------------------------------------------------------------------*/	
	
}

