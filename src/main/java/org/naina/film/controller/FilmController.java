package org.naina.film.controller;

import org.naina.film.model.Acteur;
import org.naina.film.model.Film;
import org.naina.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class FilmController {
    @Autowired
    DataSource dataSource;

    @Autowired
    FilmService filmService;

    @RequestMapping("/liste-film")
    public ModelAndView getFilms() throws SQLException {
        ModelAndView mv = new ModelAndView("film/liste-film");
        mv.addObject("listeFilm",filmService.getFilms());
        return mv;
    }
    @RequestMapping(value ="/trait-ajout-film",method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam("titre") String titre) throws SQLException{
        ModelAndView mv = new ModelAndView("film/ajout-film");
        Film film = new Film(titre);
        this.filmService.insert(film);
        return mv;
    }
}
