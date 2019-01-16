/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.define.TextDefine;
import app.entity.Catalog;
import app.model.CatalogModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author huy
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {
    CatalogModel model = null;

    public AdminController() {
        model = new CatalogModel();
    }
    
    @RequestMapping(value = "catalog-manager")
    public ModelAndView productManager(){
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/catalog_manager");
        List<Catalog> listCat =  model.getAllCatalog();
        mav.addObject("category",TextDefine.txt_danhmuc);
        mav.addObject("subcategory",TextDefine.txt_quanlydanhmuc);
        mav.addObject("listCatalog",listCat);
        return mav;
    }
}
