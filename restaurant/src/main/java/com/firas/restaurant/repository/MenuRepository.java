package com.firas.restaurant.repository;

import com.firas.restaurant.model.Address;
import com.firas.restaurant.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu,Integer> {


   List<Menu>findMenusByName( String keyword);

}



