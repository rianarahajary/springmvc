package org.naina.film.dao;

import org.naina.film.model.Acteur;
import org.naina.film.model.Suggestion;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SuggestionDAO {
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Suggestion suggestion) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO suggestions VALUES (null,?,?,?,'Creee')");
            pstmt.setInt(1, suggestion.getIdScene());
            pstmt.setDate(2, Date.valueOf(suggestion.getDebutTournage()));
            pstmt.setDate(3, Date.valueOf(suggestion.getFinTournage()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public List<Suggestion> getSuggestions() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<Suggestion> suggestions = new ArrayList<Suggestion>();
        try {
            String query = "SELECT * FROM suggestions where status != ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,"Valid");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Suggestion suggestion = new Suggestion(
                        rs.getInt("idSuggestion"),
                        rs.getInt("idScene"),
                        rs.getDate("debutTournage").toLocalDate(),
                        rs.getDate("finTournage").toLocalDate(),
                        rs.getString("status")
                );
                suggestions.add(suggestion);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return suggestions;
    }
    public List<Suggestion> getSuggestionsValid() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<Suggestion> suggestions = new ArrayList<Suggestion>();
        try {
            String query = "SELECT * FROM suggestions where status = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,"Valid");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Suggestion suggestion = new Suggestion(
                        rs.getInt("idSuggestion"),
                        rs.getInt("idScene"),
                        rs.getDate("debutTournage").toLocalDate(),
                        rs.getDate("finTournage").toLocalDate(),
                        rs.getString("status")
                );
                suggestions.add(suggestion);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return suggestions;
    }

    public void setValid(int idSuggestion) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("update suggestions set status = ? where idSuggestion = ?");
            pstmt.setString(1, "Valid");
            pstmt.setInt(2,idSuggestion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public void delete(int idSuggestion) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("DELETE from suggestions where idSuggestion = ?");
            pstmt.setInt(1, idSuggestion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
