/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.define.TextDefine;
import app.entity.Catalog;
import app.entity.Product;
import app.entity.Specification;
import app.model.CatalogModel;
import app.model.ProductModel;
import java.util.ArrayList;
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

    @RequestMapping(value = "index")
    public ModelAndView goIndex() {
        ModelAndView mav = new ModelAndView("backend/pages/index");
        return mav;
    }

    @RequestMapping(value = "error")
    public ModelAndView goError() {
        ModelAndView mav = new ModelAndView("backend/pages/error");
        return mav;
    }

    //**********************************Catalog**********************************//
    @RequestMapping(value = "catalog-manager")
    @ResponseBody
    public ModelAndView catalogManager() {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/content");
        List<Catalog> listCat = catalogModel.getAllCatalog(true);
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_quanlydanhmuc);
        mav.addObject("listCatalog", listCat);
        return mav;
    }

    @RequestMapping(value = "catalog-goinsert")
    @ResponseBody
    public ModelAndView goCatalogInsert() {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/content_insert");
        //Catalog new
        Catalog catalog = new Catalog();
        //Catalog parent select
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        //Catalog id generate
        int max = 0;
        for (Catalog cat : listCatalog) {
            int numId = Integer.parseInt(cat.getCatalogId().substring(2));
            if (numId > max) {
                max = numId;
            }
        }
        String catalogId = String.format("CA%03d", max + 1);
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("catalog-insert", catalog);
        mav.addObject("listcatalog", listCatalog);
        mav.addObject("catalogId", catalogId);
        return mav;
    }

    @RequestMapping(value = "catalog-insert")
    @ResponseBody
    public String insertCatalog(Catalog catalog) {
        boolean result = catalogModel.insertCatalog(catalog);
        JSONObject obj = new JSONObject();
        obj.put("insertsuccess", result);
        return obj.toJSONString();
    }

    @RequestMapping(value = "catalog-goedit")
    @ResponseBody
    public ModelAndView goCatalogEdit(String catalogId) {
        ModelAndView mav = new ModelAndView("backend/pages/CatalogManager/content_edit");
        //Catalog new
        Catalog catalog = catalogModel.getCatalogById(catalogId, true);
        //Catalog parent select
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        for (int i = 0; i < listCatalog.size(); i++) {
            if (listCatalog.get(i).getCatalogId().equals(catalogId)) {
                listCatalog.remove(i);
                break;
            }
        }
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("catalog-edit", catalog);
        mav.addObject("listcatalog", listCatalog);
        mav.addObject("catalogId", catalogId);
        return mav;
    }

    @RequestMapping(value = "catalog-edit")
    @ResponseBody
    public String editCatalog(Catalog catalog) {
        boolean result = catalogModel.updateCatalog(catalog);
        JSONObject obj = new JSONObject();
        obj.put("editsuccess", result);
        return obj.toJSONString();
    }

    @RequestMapping(value = "catalog_toggle")
    @ResponseBody
    public String toggleCatalog(String catalogId) {
        boolean result = catalogModel.toggleCatalog(catalogId);
        JSONObject obj = new JSONObject();
        obj.put("status", result);
        return obj.toJSONString();
    }

    @RequestMapping(value = "catalog_delete")
    @ResponseBody
    public String deleteCatalog(String catalogId) {
        boolean result = catalogModel.deleteCatalog(catalogId);
        JSONObject obj = new JSONObject();
        obj.put("delete_result", result);
        return obj.toJSONString();
    }

    //**********************************Product**********************************//
    @RequestMapping(value = "product-manager")
    public ModelAndView productManager() {
        ModelAndView mav = new ModelAndView("backend/pages/ProductManager/content");
        List<Product> listProduct = productModel.getAllProduct(true);
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_quanlysanpham);
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @RequestMapping(value = "product-goinsert")
    @ResponseBody
    public ModelAndView goProductInsert() {
        ModelAndView mav = new ModelAndView("backend/pages/ProductManager/content_insert");
        //Product new
        Product product = new Product();
        //Specification
        List<Specification> listpecification = new ArrayList<>();
        listpecification.add(new Specification("Hãng sản xuất"));
        listpecification.add(new Specification("3G"));
        listpecification.add(new Specification("4G"));
        listpecification.add(new Specification("Kích thước"));
        listpecification.add(new Specification("Trọng lượng"));
        listpecification.add(new Specification("Loại SIM"));
        listpecification.add(new Specification("Loại màn hình"));
        listpecification.add(new Specification("Kích thước màn hình"));
        listpecification.add(new Specification("Độ phân giải màn hình"));
        listpecification.add(new Specification("Hệ điều hành"));
        listpecification.add(new Specification("Màu sắc"));
        listpecification.add(new Specification("Bộ nhớ "));
        product.setSpecification(listpecification);
        //Product parent select
        List<Product> listProduct = productModel.getAllProduct(true);
        //Product id generate
        int max = 0;
        for (Product pro : listProduct) {
            int numId = Integer.parseInt(pro.getProductId().substring(2));
            if (numId > max) {
                max = numId;
            }
        }
        String productId = String.format("PM%05d", max + 1);
        //Catalog
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("product-insert", product);
        mav.addObject("product-insert", product);
        mav.addObject("listcatalog", listCatalog);
        mav.addObject("productId", productId);
        return mav;
    }

    @RequestMapping(value = "product-insert")
    @ResponseBody
    public String insertProduct(Product product) {
        boolean result = productModel.insertProduct(product);
        JSONObject obj = new JSONObject();
        obj.put("insertsuccess", result);
        return obj.toJSONString();
    }

    @RequestMapping(value = "product-goedit")
    @ResponseBody
    public ModelAndView goProductEdit(String productId) {
        ModelAndView mav = new ModelAndView("backend/pages/ProductManager/content_edit");
        //Catalog new
        Product product = productModel.getProductById(productId);
        //Catalog parent select
        List<Catalog> listCatalog = catalogModel.getAllCatalog(true);
        //Add property
        mav.addObject("category", TextDefine.txt_danhmuc);
        mav.addObject("subcategory", TextDefine.txt_themlydanhmuc);
        mav.addObject("product-edit", product);
        mav.addObject("listcatalog", listCatalog);
        return mav;
    }

    @RequestMapping(value = "product-edit")
    @ResponseBody
    public String editProduct(Product product) {
        boolean result = productModel.updateProduct(product);
        JSONObject obj = new JSONObject();
        obj.put("editsuccess", result);
        return obj.toJSONString();
    }

    @RequestMapping(value = "product_toggle")
    @ResponseBody
    public String toggleProduct(String productId) {
        boolean result = productModel.toggleProduct(productId);
        JSONObject obj = new JSONObject();
        obj.put("status", result);
        return obj.toJSONString();
    }

    @RequestMapping(value = "product_delete")
    @ResponseBody
    public String deleteProduct(String productId) {
        boolean result = productModel.deleteProduct(productId);
        JSONObject obj = new JSONObject();
        obj.put("delete_result", result);
        return obj.toJSONString();
    }
}
