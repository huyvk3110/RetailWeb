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
    public ModelAndView productManager() {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/catalog_manager");
        List<Catalog> listCat = model.getAllCatalog(true);
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_quanlydanhmuc);
        mav.addObject("listCatalog", listCat);
        return mav;
    }

    @RequestMapping(value = "catalog-insert")
    public ModelAndView goInsert() {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/catalog_insert");
        Catalog catalog = new Catalog();
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("catalog", catalog);
        return mav;
    }

    @RequestMapping(value = "catalog-edit")
    public ModelAndView goEdit(String catalogId) {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/catalog_edit");
        Catalog catalog = model.getCatalogById(catalogId);
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("catalog", catalog);
        return mav;
    }

    @RequestMapping(value = "toggle")
    public String toggleCatalog(String catalogId) {
        model.toggleCatalog(catalogId);
        return "redirect:catalog-manager.htm";
    }

    @RequestMapping(value = "delete")
    public String deleteCatalog(String catalogId) {
        model.deleteCatalog(catalogId);
        return "redirect:catalog-manager.htm";
    }

    @RequestMapping(value = "insert")
    public String insertCatalog(Catalog catalog) {
        if (model.insertCatalog(catalog)) {
            return "redirect:catalog-manager.htm";
        } else {
            return "redirect:catalog-manager.htm";
        }
    }

    @RequestMapping(value = "edit")
    public String updateCatalog(Catalog catalog) {
//        if (model.updateCatalog(catalog)) {
            return "redirect:catalog-manager.htm";
//        } else {
//            return "redirect:catalog-manager.htm";
//        }
    }
}
