/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.define.TextDefine;
import app.entity.Catalog;
import app.entity.Product;
import app.model.CatalogModel;
import app.model.ProductModel;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author huy
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    CatalogModel catalogModel = null;
    ProductModel productModel = null;

    public AdminController() {
        catalogModel = new CatalogModel();
        productModel = new ProductModel();
    }

    //**********************************Catalog**********************************//
    @RequestMapping(value = "catalog-manager")
    public ModelAndView catalogManager() {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/catalog_manager");
        List<Catalog> listCat = catalogModel.getAllCatalog(true);
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_quanlydanhmuc);
        mav.addObject("listCatalog", listCat);
        return mav;
    }

    @RequestMapping(value = "catalog-goinsert")
    public ModelAndView goCatalogInsert() {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/catalog_insert");
        //Catalog new
        Catalog catalog = new Catalog();
        //Catalog parent select
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        //Catalog id generate
        int max = 0;
        for (Catalog cat : listCatalog) {
            int numId = Integer.parseInt(cat.getCatalogId().substring(2));
            if(numId > max) max = numId;
        }
        String catalogId = String.format("CA%03d", max + 1);
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("catalog", catalog);
        mav.addObject("listcatalog", listCatalog);
        mav.addObject("catalogId", catalogId);
        return mav;
    }
    
    @RequestMapping(value = "catalog-insert")
    public String insertCatalog(Catalog catalog) {
        if (catalogModel.insertCatalog(catalog)) {
            return "redirect:catalog-manager.htm";
        } else {
            return "backend/pages/error";
        }
    }

    @RequestMapping(value = "catalog-goedit")
    public ModelAndView goCatalogEdit(String catalogId) {        
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/catalog_edit");
        //Catalog new
        Catalog catalog = catalogModel.getCatalogById(catalogId,true);
        //Catalog parent select
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        for (int i = 0; i<listCatalog.size() ; i++ ) {
            if(listCatalog.get(i).getCatalogId().equals(catalogId)){
                listCatalog.remove(i);
                break;
            }
        }
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("catalog", catalog);
        mav.addObject("listcatalog", listCatalog);
        mav.addObject("catalogId", catalogId);
        return mav;
    }
    
    @RequestMapping(value = "catalog-edit")
    public String editCatalog(Catalog catalog) {
        if (catalogModel.updateCatalog(catalog)) {
            return "redirect:catalog-manager.htm";
        } else {
            return "redirect:catalog-manager.htm";
        }
    }

    @RequestMapping(value = "catalog_toggle")
    @ResponseBody public String toggleCatalog(String catalogId) {
        boolean result = catalogModel.toggleCatalog(catalogId);
        JSONObject obj = new JSONObject();
        obj.put("status", result);
        return obj.toJSONString();
    }

    @RequestMapping(value = "catalog_delete")
    @ResponseBody public String deleteCatalog(String catalogId) {
        boolean result = catalogModel.deleteCatalog(catalogId);
        JSONObject obj = new JSONObject();
        obj.put("delete_result", result);
//        return "redirect:catalog-manager.htm";
        return obj.toJSONString();
    }
    
    //**********************************Product**********************************//
    @RequestMapping(value = "product-manager")
    public ModelAndView productManager() {
        ModelAndView mav = new ModelAndView("backend/pages/ProductManager/product_manager");
        List<Product> listProduct = productModel.getAllProduct(true);
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_quanlysanpham);
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @RequestMapping(value = "product-goinsert")
    public ModelAndView goProductInsert() {
        ModelAndView mav = new ModelAndView("backend/pages/ProductManager/product_insert");
        //Product new
        Product product = new Product();
        //Product parent select
        List<Product> listProduct = productModel.getAllProduct(true);
        //Product id generate
        int max = 0;
        for (Product pro : listProduct) {
            int numId = Integer.parseInt(pro.getProductId().substring(2));
            if(numId > max) max = numId;
        }
        String productId = String.format("PM%05d", max + 1);
        //Catalog
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("product", product);
        mav.addObject("listcatalog", listCatalog);
        mav.addObject("productId", productId);
        return mav;
    }
    
    @RequestMapping(value = "product-insert")
    public String insertProduct(Product product) {
        if (productModel.insertProduct(product)) {
            return "redirect:product-manager.htm";
        } else {
            return "backend/pages/error";
        }
    }

    @RequestMapping(value = "product-goedit")
    public ModelAndView goProductEdit(String productId) {        
        ModelAndView mav = new ModelAndView("backend/pages/ProductManager/product_edit");
        //Catalog new
        Product product = productModel.getProductById(productId);
        //Catalog parent select
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("product", product);
        mav.addObject("listcatalog", listCatalog);
        return mav;
    }
    
    @RequestMapping(value = "product-edit")
    public String editProduct(Product product) {
        if (productModel.updateProduct(product)) {
            return "redirect:product-manager.htm";
        } else {
            return "redirect:product-manager.htm";
        }
    }

    @RequestMapping(value = "product_toggle")
    @ResponseBody public String toggleProduct(String productId) {
        boolean result = productModel.toggleProduct(productId);
        JSONObject obj = new JSONObject();
        obj.put("status", result);
        return obj.toJSONString();
//        return "redirect:product-manager.htm";
    }

    @RequestMapping(value = "product_delete")
    @ResponseBody public String deleteProduct(String productId) {
        boolean result = productModel.deleteProduct(productId);
        JSONObject obj = new JSONObject();
        obj.put("delete_result", result);
        return obj.toJSONString();
//        return "redirect:product-manager.htm";
    }
}
