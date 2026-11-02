import java.util.Random;

public class Tamagotchi {
    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;
    private Random rand = new Random();

    public Tamagotchi(String nom) {
        this.nom = nom;
        this.age = 0;
        this.dureeDeVie = 9 + rand.nextInt(6); // 9 à 14
        this.maxEnergie = 5 + rand.nextInt(5); // 5 à 9
        this.energie = 3 + rand.nextInt(this.maxEnergie - 2);
    }

    public void parler() {
        if (energie > 5) System.out.println(nom + " : tout va bien !");
        else System.out.println(nom + " : je suis affamé !");
    }

    public void manger() {
        if (energie >= maxEnergie) {
            System.out.println(nom + " : je n'ai pas faim !!");
        } else {
            energie += 1 + rand.nextInt(3);
            if (energie > maxEnergie) energie = maxEnergie;
            System.out.println(nom + " : Merci !");
        }
    }

    public boolean ageLimite() { return age >= dureeDeVie; }

    public boolean vivre() {
        if (age >= dureeDeVie) return true;
        if (energie <= 0) {
            System.out.println(nom + " : je meurs... Arrrggh !");
            return false;
        }
        age++; energie--;
        if (ageLimite()) System.out.println(nom + " : c'est gagné pour moi !");
        else parler();
        return true;
    }
    public String getNom() { return nom; }
}