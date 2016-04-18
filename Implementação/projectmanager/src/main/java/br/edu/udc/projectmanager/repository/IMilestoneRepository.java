package br.edu.udc.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.udc.projectmanager.entity.Activity;
import br.edu.udc.projectmanager.entity.Milestone;

public interface IMilestoneRepository  extends JpaRepository<Milestone, Long> {

}
