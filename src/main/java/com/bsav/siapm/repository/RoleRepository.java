package com.bsav.siapm.repository;

import com.bsav.siapm.entities.Role;
import com.bsav.siapm.utils.Constants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Serializable> {

    Optional<Role> findByRole(Constants.ERole role);

}