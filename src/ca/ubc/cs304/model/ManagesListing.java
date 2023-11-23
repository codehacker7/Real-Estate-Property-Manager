package ca.ubc.cs304.model;

public record ManagesListing(String realEstateAgentPhone, Integer listingId) implements EntityModel {
    @Override
    public String insertStatement() {
        return "INSERT INTO ManagesListing VALUES ('%s', %d)"
                .formatted(realEstateAgentPhone, listingId);
    }}
