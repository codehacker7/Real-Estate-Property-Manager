package ca.ubc.cs304.model;

public record HiresREA(String homeownerPhone, String realEstateAgentPhone) implements EntityModel {
    @Override
    public String insertStatement() {
        return "INSERT INTO HiresREA VALUES ('%s', '%s')"
                .formatted(homeownerPhone, realEstateAgentPhone);
    }}
