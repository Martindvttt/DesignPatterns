package ipi.designpattern.candycrush;

import java.util.HashMap;
import java.util.Map;

public class CandyCrushRanking {
    // Attribut pour le singleton
    private static CandyCrushRanking instance;

    // Map pour stocker les couples login/score
    private Map<String, Integer> scores;

    // Constructeur privé pour le singleton
    private CandyCrushRanking() {
        scores = new HashMap<>();
        scores.put("bibi", 300);
        scores.put("pepette", 234);
        scores.put("boulboul", 209);
        scores.put("safinette", 202);
        scores.put("skymed", 177);
        scores.put("choupette", 78);
        scores.put("mimi", 50);
    }

    // Méthode pour récupérer l'instance du singleton
    public static CandyCrushRanking getInstance() {
        if (instance == null) {
            instance = new CandyCrushRanking();
        }
        return instance;
    }

    // Méthode pour récupérer le gagnant (joueur avec le score le plus élevé)
    public String getWinner() {
        String winner = "";
        int maxScore = 0;
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }

    // Méthode pour récupérer le perdant (joueur avec le score le plus bas)
    public String getLoser() {
        String loser = "";
        int minScore = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() < minScore) {
                minScore = entry.getValue();
                loser = entry.getKey();
            }
        }
        return loser;
    }

    // Méthode pour afficher le classement des joueurs
    public void printRanking() {
        System.out.println("Classement :");
        scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " a obtenu " + entry.getValue() + " points"));
    }
}
