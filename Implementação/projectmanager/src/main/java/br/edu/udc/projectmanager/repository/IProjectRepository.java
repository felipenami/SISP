package br.edu.udc.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.udc.projectmanager.entity.Project;
/**
 * 
 * @author Felipe Nami
 *
 */
public interface IProjectRepository extends JpaRepository<Project, Long> 
{

}
