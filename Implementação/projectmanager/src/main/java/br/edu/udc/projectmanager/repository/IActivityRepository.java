package br.edu.udc.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.udc.projectmanager.entity.Activity;

public interface IActivityRepository extends JpaRepository<Activity, Long>  {
	
	@Query(value = "SELECT new Activity( activity.id, activity.name, activity.description, activity.status, responsible, activity.date, activity.workTime, activity.duration, activity.type) "
		 	   + " FROM Activity activity "
		 	   + " JOIN activity.project project "
		 	   + " JOIN activity.responsible responsible " 
		 	   + " WHERE activity.project.id = :projectId ")
	public List<Activity> listActivityByproject(@Param("projectId") Long projectId);

}
