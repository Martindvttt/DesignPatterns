package ipi.designpattern;

import ipi.designpattern.candycrush.CandyCrushRanking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpDesignPatternApplication {
    public class User {
        public static void main(String[] args) {
            CandyCrushRanking singleton1 = CandyCrushRanking.getInstance();
            System.out.println("Premier appel à Instance () singleton. " + singleton1);
            System.out.println("Le gagnant est: " + singleton1.getWinner());
            System.out.println("Le perdant est: " + singleton1.getLoser());
            singleton1.printRanking();

            CandyCrushRanking singleton2 = CandyCrushRanking.getInstance();
            System.out.println("Deuxième appel à Instance () singleton. " + singleton2);
            System.out.println("Le gagnant est: " + singleton2.getWinner());
            System.out.println("Le perdant est: " + singleton2.getLoser());
            singleton2.printRanking();
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(TpDesignPatternApplication.class, args);
    }

}
