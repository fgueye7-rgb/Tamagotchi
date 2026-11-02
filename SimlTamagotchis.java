import java.util.ArrayList;
import java.util.Scanner;

public class SimulTamagotchis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tamagotchi> liste = new ArrayList<>();
        
        System.out.print("Combien de tamagotchis ? ");
        int n = sc.nextInt(); sc.nextLine();
        
        for (int i=0; i<n; i++) {
            System.out.print("Quel nom pour le nouveau tamagotchi : ");
            liste.add(new Tamagotchi(sc.nextLine()));
        }

        int cycle = 1;
        while (true) {
            System.out.println("\n-------Cycle no " + cycle + " -------");
            for (Tamagotchi t : liste) {
                if (!t.ageLimite()) {
                    if (!t.vivre()) { System.out.println("\nPERDU !!"); return; }
                }
            }
            boolean gagne = true;
            for (Tamagotchi t : liste) if (!t.ageLimite()) gagne = false;
            if (gagne) { System.out.println("\nGAGNE !!"); break; }

            System.out.println();
            for (int i=0; i<liste.size(); i++) 
                if (!liste.get(i).ageLimite()) System.out.print("("+i+") "+liste.get(i).getNom()+"  ");
            
            System.out.print("\nNourrir quel tamagotchi ? ");
            try { liste.get(sc.nextInt()).manger(); } 
            catch (Exception e) { sc.nextLine(); }
            cycle++;
        }
    }
}