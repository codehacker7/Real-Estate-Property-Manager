package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public record HiresREA(String homeownerPhone, String realEstateAgentPhone) implements EntityModel {
    public HiresREA(ResultSet rs) throws SQLException {
        this(
                rs.getString("homeownerPhone"),
                rs.getString("realEstateAgentPhone")
        );
    }

    @Override
    public String insertStatement(Integer id) {
        return "INSERT INTO HiresREA VALUES ('%s', '%s')"
                .formatted(homeownerPhone, realEstateAgentPhone);
    }}
