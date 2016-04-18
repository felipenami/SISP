package br.edu.udc.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.udc.projectmanager.entity.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
