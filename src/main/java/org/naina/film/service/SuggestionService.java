package org.naina.film.service;

import org.naina.film.dao.SuggestionDAO;
import org.naina.film.model.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class SuggestionService {
    @Autowired
    DataSource dataSource;

    @Autowired
    SuggestionDAO suggestionDAO;

    public List<Suggestion> getSuggestions() throws SQLException {
        this.suggestionDAO.setDataSource(this.dataSource);
        return this.suggestionDAO.getSuggestions();
    }
    public List<Suggestion> getSuggestionsValid() throws SQLException {
        this.suggestionDAO.setDataSource(this.dataSource);
        return this.suggestionDAO.getSuggestionsValid();
    }
    public void insert(Suggestion suggestion) throws SQLException {
        this.suggestionDAO.setDataSource(this.dataSource);
        this.suggestionDAO.insert(suggestion);
    }
    public void setValid(int idSuggestion)throws SQLException{
        this.suggestionDAO.setDataSource(dataSource);
        this.suggestionDAO.setValid(idSuggestion);
    }
    public void delete(int idSuggestion) throws SQLException{
        this.suggestionDAO.setDataSource(dataSource);
        this.suggestionDAO.delete(idSuggestion);
    }
}
