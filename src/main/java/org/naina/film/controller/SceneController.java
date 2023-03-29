package org.naina.film.controller;

import org.naina.film.model.*;
import org.naina.film.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class SceneController {
    @Autowired
    DataSource dataSource;
    @Autowired
    ActeurService acteurService;
    @Autowired
    PlateauService plateauService;
    @Autowired
    SceneService sceneService;
    @Autowired
    SceneActeurService sceneActeurService;
    @Autowired
    FilmService filmService;


    @RequestMapping("/ajout-scene")
    public ModelAndView ajoutScene() throws SQLException {

        ModelAndView mv = new ModelAndView("scene/ajout-scene");
        mv.addObject("listeFilm",filmService.getFilms());
        mv.addObject("listeActeur",acteurService.getActeurs());
        mv.addObject("listePlateau",plateauService.getPlateaux());
        return mv;
    }

    @RequestMapping(value = "trait-ajout-scene",method = RequestMethod.POST)
    public ModelAndView traitementAjoutScene(
                                        @RequestParam("film") int film,
                                        @RequestParam(value = "nom") String nom,
                                        @RequestParam("heureFav") String heureFav,
                                        @RequestParam("duree") int duree,
                                        @RequestParam(value = "plateau") String plateau,
                                        @RequestParam(value = "acteurs[]") Set<String> acteurs) throws SQLException {
        try{
            Scene scene = new Scene(film,Integer.parseInt(plateau),nom,LocalTime.parse(heureFav), duree);
            sceneService.insert(scene);
            int lastId = this.sceneService.getLastId();

            List<String> listeActeur = new ArrayList<>(acteurs);
            for (String acteur: listeActeur) {
                SceneActeur sceneActeur = new SceneActeur(lastId,Integer.parseInt(acteur));
                this.sceneActeurService.insert(sceneActeur);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/ajout-scene");
    }

    @RequestMapping(value = "liste-scene",method = RequestMethod.POST)
    public ModelAndView getScenesByFilm(@RequestParam("idFilm") int idFilm) throws SQLException {
        ModelAndView mv = new ModelAndView("scene/liste-scene");
        try{
            mv.addObject("listeSceneActeur",this.sceneActeurService.getSceneActeur());
            mv.addObject("listeScene",this.sceneService.getScenesByFilm(idFilm));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "/planification", method = RequestMethod.POST)
    public ModelAndView planification(@RequestParam("idScene")int idScene){
        ModelAndView mv = new ModelAndView("scene/planification");
        mv.addObject("idScene",idScene);
        return mv;
    }

    @RequestMapping(value = "/edit-scene", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam("idScene") int idScene) throws SQLException {

        ModelAndView mv = new ModelAndView("scene/edit-scene");
        mv.addObject("idScene",idScene);
        mv.addObject("listeFilm",filmService.getFilms());
        mv.addObject("listeActeur",acteurService.getActeurs());
        mv.addObject("listePlateau",plateauService.getPlateaux());
        return mv;
    }

    @RequestMapping(value = "trait-edit-scene",method = RequestMethod.POST)
    public ModelAndView traitementEditScene(
            @RequestParam("idScene") int idScene,
            @RequestParam(value = "nom") String nom,
            @RequestParam("heureFav") String heureFav,
            @RequestParam("duree") int duree,
            @RequestParam(value = "plateau") String plateau) throws SQLException {
        try{
            Scene scene = new Scene(idScene,0,Integer.parseInt(plateau),nom,LocalTime.parse(heureFav), duree,"Creee");
            sceneService.update(scene);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/liste-film");
    }
    @RequestMapping(value = "delete-scene",method = RequestMethod.POST)
    public ModelAndView deleteScene(
            @RequestParam("idScene") int idScene) throws SQLException {
        try{
            sceneService.delete(idScene);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/liste-film");
    }

}
