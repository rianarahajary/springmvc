package org.naina.film.controller;

import org.naina.film.dao.ActeurDAO;
import org.naina.film.model.Acteur;
import org.naina.film.service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;


@Controller
public class ActeurController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private ActeurService acteurService;

    @RequestMapping("/liste-acteur")
    public ModelAndView getActeurs() throws SQLException {
        ModelAndView mv = new ModelAndView("acteur/liste-acteur");
        mv.addObject("listeActeur",acteurService.getActeurs());
        return mv;
    }
    @RequestMapping(value ="/trait-ajout-acteur",method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam("nom") String nom) throws SQLException{
        Acteur acteur = new Acteur(nom);
        this.acteurService.insert(acteur);
        return new ModelAndView("redirect:/liste-acteur");
    }
    @RequestMapping(value ="/delete-acteur",method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("idActeur") int idActeur) throws SQLException{
        Acteur acteur = new Acteur(idActeur,"");
        this.acteurService.delete(acteur);
        return new ModelAndView("redirect:/liste-acteur");
    }
    @RequestMapping(value ="/edit-acteur",method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam("idActeur") int idActeur) throws SQLException{
        ModelAndView mv = new ModelAndView("acteur/edit-acteur");
        mv.addObject("idActeur",idActeur);
        return mv;
    }
    @RequestMapping(value ="/trait-edit-acteur",method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam("idActeur") int idActeur,
                             @RequestParam("nom") String nom) throws SQLException{
        Acteur acteur = new Acteur(idActeur,nom);
        this.acteurService.update(acteur);
        ModelAndView mv = new ModelAndView("acteur/liste-acteur");
        mv.addObject("listeActeur",acteurService.getActeurs());
        return mv;
    }
}
