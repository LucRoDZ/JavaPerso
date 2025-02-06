package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.epita.assistants.nucbattle.ReportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report {
    private ReportType type;
    private String player;
    private Map<String, Float> outcome;
}
