package ca.ubc.cs304.sql.scripts;

public final class SQLScripts {
    public static final String CREATE_TABLE_PERSON =
                    "CREATE TABLE Person " +
                    "(" +
                        "homeownerPhone CHAR(20) PRIMARY KEY, " +
                        "name  CHAR(255), " +
                        "email CHAR(255)" +
                    ")";
    public static final String CREATE_TABLE_HOMEOWNER =
                    "CREATE TABLE Homeowner " +
                    "(" +
                        "homeownerPhone CHAR(20) PRIMARY KEY, " +
                        "FOREIGN KEY (homeownerPhone) REFERENCES Person (homeownerPhone) " +
                            "ON DELETE CASCADE" +
                    ")";
    public static final String CREATE_TABLE_REAL_ESTATE_AGENCY =
                    "CREATE TABLE RealEstateAgency " +
                    "(" +
                        "agencyID INTEGER PRIMARY KEY, " +
                        "name     CHAR(255), " +
                        "rating   DOUBLE PRECISION" +
                    ")";
    public static final String CREATE_TABLE_REAL_ESTATE_AGENT =
                    "CREATE TABLE RealEstateAgent " +
                    "(" +
                        "homeownerPhone          CHAR(20) PRIMARY KEY, " +
                        "agentLicenseID INTEGER UNIQUE, " +
                        "yearsOfExp     INTEGER, " +
                        "agencyID       INTEGER NOT NULL, " +
                        "FOREIGN KEY (homeownerPhone) REFERENCES Person (homeownerPhone) " +
                            "ON DELETE CASCADE, " +
                        "FOREIGN KEY (agencyID) REFERENCES RealEstateAgency (agencyID) " +
                            "ON DELETE CASCADE" +
                    ")";
    public static final String CREATE_TABLE_DEVELOPER =
                    "CREATE TABLE Developer " +
                    "(" +
                        "developerLicenseID INTEGER PRIMARY KEY, " +
                        "name               CHAR(255)" +
                    ")";
    public static final String CREATE_TABLE_CONTRACTOR_COMPANY =
                    "CREATE TABLE ContractorCompany " +
                    "(" +
                        "contractorID   INTEGER PRIMARY KEY, " +
                        "name           CHAR(255), " +
                        "chargeSchedule CHAR(255)" +
                    ")";
    public static final String CREATE_TABLE_STRATA =
                    "CREATE TABLE Strata " +
                    "(" +
                        "strataID INTEGER PRIMARY KEY, " +
                        "name     VARCHAR(255)" +
                    ")";
    public static final String CREATE_TABLE_CITY =
                    "CREATE TABLE City " +
                    "(" +
                        "province CHAR(255), " +
                        "name     CHAR(255), " +
                        "taxRate  DOUBLE PRECISION, " +
                        "PRIMARY KEY (province, name)" +
                    ")";
    public static final String CREATE_TABLE_PROPERTY =
                    "CREATE TABLE Property " +
                    "(" +
                        "streetAddress      CHAR(255), " +
                        "province           CHAR(255), " +
                        "cityName           CHAR(255), " +
                        "developerLicenseID INTEGER NOT NULL, " +
                        "strataID           INTEGER, " +
                        "homeownerPhone     CHAR(20), " +
                        "bedrooms           INTEGER, " +
                        "bathrooms          INTEGER, " +
                        "sizeInSqft         INTEGER, " +
                        "hasAC              Number(1,0), " +
                        "PRIMARY KEY (streetAddress, province, cityName), " +
                        "FOREIGN KEY (province, cityName) REFERENCES City (province, name) " +
                            "ON DELETE CASCADE, " +
                        "FOREIGN KEY (strataID) REFERENCES Strata (strataID), " +
                        "FOREIGN KEY (homeownerPhone) REFERENCES Homeowner (homeownerPhone), " +
                        "FOREIGN KEY (developerLicenseID) REFERENCES Developer (developerLicenseID) " +
                            "ON DELETE CASCADE" +
                    ")";
    public static final String CREATE_TABLE_LISTING =
                    "CREATE TABLE Listing" +
                    "(" +
                        "listingID            INTEGER PRIMARY KEY," +
                        "realEstateAgentPhone CHAR(20) NOT NULL," +
                        "streetAddress        CHAR(255)," +
                        "province             CHAR(255)," +
                        "cityName             CHAR(255)," +
                        "type                 CHAR(255)," +
                        "price                INTEGER," +
                        "active               NUMBER(1, 0)," +
                        "FOREIGN KEY (streetAddress, cityName, province) REFERENCES Property (streetAddress, cityName, province)" +
                        "    ON DELETE CASCADE," +
                        "FOREIGN KEY (realEstateAgentPhone) REFERENCES RealEstateAgent (homeownerPhone)," +
                        "UNIQUE (streetAddress, cityName, province)" +
                    ")";
    public static final String CREATE_TABLE_HIRES_REA =
                    "CREATE TABLE HiresREA " +
                    "(" +
                        "homeownerPhone       CHAR(20), " +
                        "realEstateAgentPhone CHAR(20), " +
                        "PRIMARY KEY (homeownerPhone, realEstateAgentPhone), " +
                        "FOREIGN KEY (homeownerPhone) REFERENCES Homeowner (homeownerPhone) " +
                            "ON DELETE CASCADE, " +
                        "FOREIGN KEY (realEstateAgentPhone) REFERENCES RealEstateAgent (homeownerPhone) " +
                            "ON DELETE CASCADE" +
                    ")";
    public static final String CREATE_TABLE_HIRES_CONTRACTOR =
                    "CREATE TABLE HiresContractor " +
                    "(" +
                        "homeownerPhone CHAR(20), " +
                        "contractorID   INTEGER, " +
                        "PRIMARY KEY (homeownerPhone, contractorID), " +
                        "FOREIGN KEY (homeownerPhone) REFERENCES Homeowner (homeownerPhone) " +
                            "ON DELETE CASCADE, " +
                        "FOREIGN KEY (contractorID) REFERENCES ContractorCompany (contractorID) " +
                            "ON DELETE CASCADE" +
                    ")";
    public static final String CREATE_TABLE_PAYS =
                    "CREATE TABLE Pays " +
                    "(" +
                        "homeownerPhone CHAR(20), " +
                        "strataID       INTEGER, " +
                        "fee            INTEGER, " +
                        "PRIMARY KEY (homeownerPhone, strataID), " +
                        "FOREIGN KEY (homeownerPhone) REFERENCES Homeowner (homeownerPhone) " +
                            "ON DELETE CASCADE, " +
                        "FOREIGN KEY (strataID) REFERENCES Strata (strataID) " +
                            "ON DELETE CASCADE" +
                    ")";
    public static final String CREATE_TABLE_MAINTAINS =
                    "CREATE TABLE Maintains " +
                    "(" +
                        "contractorID         INTEGER, " +
                        "streetAddress        CHAR(255), " +
                        "province             CHAR(255), " +
                        "cityName             CHAR(255), " +
                        "areaOfResponsibility CHAR(255), " +
                        "PRIMARY KEY (contractorID, streetAddress, province, cityName), " +
                        "FOREIGN KEY (streetAddress, cityName, province) REFERENCES Property (streetAddress, cityName, province) " +
                            "ON DELETE CASCADE, " +
                        "FOREIGN KEY (contractorID) REFERENCES ContractorCompany (contractorID) " +
                            "ON DELETE CASCADE, " +
                        "UNIQUE (streetAddress, province, cityName, areaOfResponsibility)" +
                    ")";
}
