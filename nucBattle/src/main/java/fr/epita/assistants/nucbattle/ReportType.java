package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReportType {
    WINNER,
    CHEATER,
    ERROR,
    UNFINISHED;

    @JsonValue
    public String toLowerCase() {
        return name().toLowerCase();
    }
}

