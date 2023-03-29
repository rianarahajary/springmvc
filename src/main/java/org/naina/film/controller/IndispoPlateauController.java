package org.naina.film.controller;

import org.naina.film.model.Acteur;
import org.naina.film.model.IndispoPlateau;
import org.naina.film.service.IndispoPlateauService;
import org.naina.film.service.PlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class IndispoPlateauController {
    @Autowired
    DataSource dataSource;
    @Autowired
    IndispoPlateauService indispoPlateauService;
    @Autowired
    PlateauService plateauService;

    @RequestMapping("/liste-indispo-plateau")
    public ModelAndView getIndispoPlateaux() throws SQLException {
        ModelAndView mv = new ModelAndView("indisponibilite/liste-indispo-plateau");
        mv.addObject("listeIndispoPlateau",indispoPlateauService.getIndispoPlateaux());
        return mv;
    }
    @RequestMapping("/ajout-indispo-plateau")
    public ModelAndView ajoutIndispoPlateau() throws SQLException {
        ModelAndView mv = new ModelAndView("indisponibilite/ajout-indispo-plateau");
        mv.addObject("listePlateau",plateauService.getPlateaux());
        return mv;
    }

    @RequestMapping(value ="/trait-ajout-indispo-plateau",method = RequestMethod.POST)
    public ModelAndView insert(
            @RequestParam("plateau")int idPlateau,
            @RequestParam("date") String date,
            @RequestParam("heureDebut") String heureDebut,
            @RequestParam("heureFin") String heureFin) throws SQLException{

        IndispoPlateau indispoPlateau = new IndispoPlateau(
                idPlateau,
                LocalDate.parse(date),
                LocalTime.parse(heureDebut),
                LocalTime.parse(heureFin));
        try{
            this.indispoPlateauService.insert(indispoPlateau);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/liste-indispo-plateau");
    }
    @RequestMapping(value = "/delete-indispo-plateau",method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("idIndispoPlateau") int idIndispoPlateau){
        try{
            this.indispoPlateauService.delete(idIndispoPlateau);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/liste-indispo-plateau");
    }
}
