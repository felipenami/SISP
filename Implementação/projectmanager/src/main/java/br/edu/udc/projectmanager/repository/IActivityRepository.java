package br.edu.udc.projectmanager.repository;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.udc.projectmanager.entity.Activity;
import br.edu.udc.projectmanager.entity.User;

public interface IActivityRepository extends JpaRepository<Activity, Long>  {
	

}
