package org.naina.film.controller;

import org.naina.film.model.Acteur;
import org.naina.film.model.Plateau;
import org.naina.film.service.PlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class PlateauController {
    @Autowired
    DataSource dataSource;
    @Autowired
    PlateauService plateauService;

    @RequestMapping("/liste-plateau")
    public ModelAndView getActeurs() throws SQLException {
        ModelAndView mv = new ModelAndView("plateau/liste-plateau");
        mv.addObject("listePlateau",plateauService.getPlateaux());
        return mv;
    }
    @RequestMapping("/edit-plateau")
    public ModelAndView editPlateau(@RequestParam("idPlateau") int idPlateau){
        ModelAndView mv =  new ModelAndView("plateau/edit-plateau");
        mv.addObject("idPlateau",idPlateau);
        return mv;
    }

    @RequestMapping(value ="/trait-ajout-plateau",method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam("nom") String nom) throws SQLException {
        ModelAndView mv = new ModelAndView("redirect:/liste-plateau");
        mv.addObject("listePlateau",plateauService.getPlateaux());
        Plateau plateau = new Plateau(nom);
        this.plateauService.insert(plateau);
        return mv;
    }
    @RequestMapping(value ="/trait-edit-plateau",method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam("idPlateau") int idPlateau,
                             @RequestParam("nom")String nom) throws SQLException{
        Plateau plateau = new Plateau(idPlateau,nom);
        this.plateauService.update(plateau);
        return new ModelAndView("redirect:/liste-plateau");
    }
    @RequestMapping(value ="/delete-plateau",method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam("idPlateau") int idPlateau) throws SQLException{
        ModelAndView mv = new ModelAndView("redirect:/liste-plateau");
        mv.addObject("listePlateau",plateauService.getPlateaux());
        this.plateauService.delete(idPlateau);
        return mv;
    }
}
