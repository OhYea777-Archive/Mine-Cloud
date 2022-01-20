package com.ohyea777.minecloud.prison;

public class Rank {

    private String group;
    private String localisedName;
    private double cost;
    private Boolean isDefaultRank;
    private Boolean isSubRank;

    public Rank() { }

    public Rank(String group, String localisedName, double cost, Boolean isDefaultRank, Boolean isSubRank) {
        this.group = group;
        this.localisedName = localisedName;
        this.cost = cost;
        this.isDefaultRank = isDefaultRank;
        this.isSubRank = isSubRank;
    }

    public Rank(String group, String localisedName, double cost, Boolean isDefaultRank) {
        this(group, localisedName, cost, isDefaultRank, false);
    }

    public Rank(String group, String localisedName, double cost) {
        this(group, localisedName, cost, false);
    }

    public Rank(String group, double cost) {
        this(group, group, cost);
    }

    public String getGroup() {
        if (group == null) {
            group = "";
        }

        return group;
    }

    public String getLocalisedName() {
        if (localisedName == null) {
            localisedName = "";
        }

        return localisedName;
    }

    public double getCost() {
        return cost;
    }

    public Boolean isDefaultRank() {
        if (isDefaultRank == null) {
            isDefaultRank = false;
        }

        return isDefaultRank;
    }

    public Boolean isSubRank() {
        if (isSubRank == null) {
            isSubRank = false;
        }

        return isSubRank;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Rank = [ ");
        builder.append(String.format("group = '%s'", getGroup())).append(", ");
        builder.append(String.format("localisedName = '%s'", getLocalisedName())).append(", ");
        builder.append(String.format("cost = '%s'", getCost())).append(", ");
        builder.append(String.format("isDefaultRank = '%s'", isDefaultRank())).append(", ");
        builder.append(String.format("isSubRank = '%s'", isSubRank()));
        builder.append(" ]");

        return builder.toString();
    }
}