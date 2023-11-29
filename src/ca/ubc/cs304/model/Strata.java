package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public record Strata(Integer strataId, String name) implements HasID {
    public Strata(ResultSet rs) throws SQLException {
        this(
                rs.getInt("strataID"),
                rs.getString("name")
        );
    }

    @Override
    public String insertStatement(Integer id) {
        return "INSERT INTO Strata VALUES (%d, '%s')"
                .formatted(strataId, name);
    }

    @Override
    public String getIdSQL() {
        return "SELECT max(strataID) FROM Listing";
    }

    @Override
    public Integer defaultId() {
        return 4000001;
    }
}
