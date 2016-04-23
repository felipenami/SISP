package br.edu.udc.projectmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.udc.projectmanager.entity.Project;
/**
 * 
 * @author Felipe Nami
 *
 */
public interface IProjectRepository extends JpaRepository<Project, Long> 
{

	@Query(value="SELECT new Project(project.id, " +
									"project.status, " +
									"project.initialDate, " +
									"project.finalDate, " +
									"project.name, " +
									"project.projectManager ) " +
						"FROM Project project " +
						"WHERE (FILTER(project.name, :filter) = TRUE ) ")
		public Page<Project>listByFilters( @Param("filter") String filter, Pageable pageable );
	
}
