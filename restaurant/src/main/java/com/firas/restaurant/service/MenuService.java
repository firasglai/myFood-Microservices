package com.firas.restaurant.service;

import com.firas.restaurant.model.Menu;
import com.firas.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }



    public List<Menu> findMenusByKeyword(String keyword) {
        return menuRepository.findMenusByName(keyword);
    }

}
