package org.naina.film.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RouteController {
    @RequestMapping("")
    public ModelAndView index(){
        return new ModelAndView("calendrier/calendrier");
    }

//    FILM
    @RequestMapping("/ajout-film")
    public ModelAndView ajoutFilm(){
        return new ModelAndView("film/ajout-film");
    }
//    SUGGESTION
//    ACTEUR
    @RequestMapping("/ajout-acteur")
    public ModelAndView ajoutActeur(){
        return new ModelAndView("acteur/ajout-acteur");
    }
//    PLATEAU
    @RequestMapping("/ajout-plateau")
    public ModelAndView ajoutPlateau(){
        return new ModelAndView("plateau/ajout-plateau");
    }
}
