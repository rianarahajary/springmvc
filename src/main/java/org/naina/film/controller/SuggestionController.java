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
import java.time.LocalDate;
import java.util.List;

@Controller
public class SuggestionController {
    @Autowired
    DataSource dataSource;
    @Autowired
    SuggestionService suggestionService;
    @Autowired
    IndispoPlateauService indispoPlateauService;
    @Autowired
    SceneActeurService sceneActeurService;
    @Autowired
    SceneService sceneService;

    @RequestMapping("/suggestion")
    public ModelAndView suggestion() throws SQLException {
        ModelAndView mv = new ModelAndView("suggestion/suggestion");
        mv.addObject("listeSuggestion",this.suggestionService.getSuggestions());
        return mv;
    }

    @RequestMapping(value = "/ajout-suggestion", method = RequestMethod.POST)
    public ModelAndView ajoutSuggestion(
            @RequestParam("debutTournage") String debutTournage,
            @RequestParam("finTournage") String finTournage,
            @RequestParam("idScene")int idScene) throws SQLException {

        Suggestion suggestion = new Suggestion(idScene, LocalDate.parse(debutTournage),LocalDate.parse(finTournage));
        Scene scene = sceneService.getSceneById(idScene);
        List<SceneActeur> listeActeursDansScene = sceneActeurService.getActeursByScene(idScene);

        boolean dispo = false;
        while (!dispo) {
            try {
                if (indispoPlateauService.isDispo(scene.getIdPlateau(), suggestion.getDebutTournage(), suggestion.getFinTournage())) {
                    dispo = true;
                    suggestionService.insert(suggestion);
                } else {
                    suggestion.setDebutTournage(suggestion.getDebutTournage().plusDays(1));
                    suggestion.setFinTournage(suggestion.getFinTournage().plusDays(1));
                    System.out.println("New debut " + suggestion.getDebutTournage());
                    System.out.println("New fin " + suggestion.getFinTournage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ModelAndView("redirect:/suggestion");
    }
    @RequestMapping(value = "/valider-suggestion",method = RequestMethod.POST)
    public ModelAndView validerSuggestion(@RequestParam("idSuggestion") int idSuggestion) throws SQLException {
        try {
            suggestionService.setValid(idSuggestion);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/suggestion");
    }

    @RequestMapping(value = "delete-suggestion",method = RequestMethod.POST)
    public ModelAndView deleteSuggestion(@RequestParam("idSuggestion") int idSuggestion) throws SQLException{
        try {
            suggestionService.delete(idSuggestion);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/suggestion");
    }

}
