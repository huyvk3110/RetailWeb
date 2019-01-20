/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author huy
 */
@Controller
@RequestMapping(value = "admin")
public class ProductController {
    @RequestMapping(value = "getAll")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("backend/index");
        return mav;
    }
}
