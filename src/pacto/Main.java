package pacto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Temporada temporada = new Temporada();
        System.out.println("Configuração da partida — até quatro participantes.");
        int total = ler(sc, "Número de participantes (2 a 4): ");
        if (total < 2 || total > 4) { System.out.println("A partida precisa de 2 a 4 participantes."); return; }
        for (int i = 0; i < total; i++) {
            System.out.print("Nome do participante " + (i + 1) + ": ");
            String nome = sc.nextLine().trim();
            if (nome.isBlank()) nome = "Regente " + (i + 1);
            String cidade = (i % 2 == 0) ? "Bolonha" : "Milano";
            if (i >= 2) cidade += " — Distrito " + (i - 1);
            temporada.inscrever(new Assentamento(cidade, new Participante(nome)));
        }
        new ConsoleJogo(sc, temporada).executar();
    }
    private static int ler(Scanner sc, String msg) { System.out.print(msg); try { return Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { return -1; } }
}
