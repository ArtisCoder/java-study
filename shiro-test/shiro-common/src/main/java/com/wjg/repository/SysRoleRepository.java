package com.wjg.repository;

import com.wjg.entity.SysRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by archerlj on 2017/7/4.
 */
public interface SysRoleRepository extends CrudRepository<SysRole, Long> {

    List<SysRole> findAllByDescriptionIn(Collection<String> roleNames);
}
