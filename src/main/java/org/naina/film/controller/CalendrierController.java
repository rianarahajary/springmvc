package org.naina.film.controller;

import org.naina.film.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Calendar;

@Controller
public class CalendrierController {
    @Autowired
    DataSource dataSource;

    @Autowired
    SuggestionService suggestionService;

    @RequestMapping("/calendrier")
    public ModelAndView calendrier() throws SQLException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("year",2023);
        mv.addObject("month", Calendar.JANUARY);
        mv.addObject("listeSuggestion",suggestionService.getSuggestionsValid());
        mv.setViewName("calendrier/calendrier");
        return mv;
    }
    @RequestMapping(value = "/changeMonth", method = RequestMethod.POST)
    public ModelAndView changeMonth(@RequestParam("month")int month,@RequestParam("year") int year) throws SQLException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("year",year);
        mv.addObject("month", month);
        mv.addObject("listeSuggestion",suggestionService.getSuggestionsValid());
        mv.setViewName("calendrier/calendrier");
        return mv;
    }
}
