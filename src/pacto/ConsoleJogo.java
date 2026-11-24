package pacto;

import java.util.Scanner;

public class ConsoleJogo {
    private final Scanner entrada;
    private final Temporada temporada;
    private final BolsaDeTrocas bolsa = new BolsaDeTrocas();
    private final Safra safra = new Safra();
    private final Conselho conselho = new Conselho();
    private final ObrasDoConselho obras = new ObrasDoConselho();
    public ConsoleJogo(Scanner entrada, Temporada temporada) { this.entrada = entrada; this.temporada = temporada; }
    public void executar() {
        System.out.println("\n╔══════════════════════════════════════╗\n║       PACTO DAS DUAS CIDADES         ║\n║       Bolonha  •  Milano             ║\n╚══════════════════════════════════════╝");
        while (!temporada.encerrada()) {
            Assentamento a = temporada.getAssentamentoDaVez();
            if (a == null) return;
            a.exibirPainel();
            System.out.println("\n1 Colher | 2 Abastecer | 3 Comprar grãos | 4 Vender grãos | 5 Recolher tributo | 6 Ajustar tributo | 7 Construir | 8 Formar guarda | 9 Passar vez | 0 Encerrar");
            int op = ler("Escolha: ");
            if (op == 0) break;
            switch (op) {
                case 1 -> { int r = safra.colher(a); System.out.println(r < 0 ? "A safra já foi realizada." : "Saldo da colheita: " + r + " grãos."); }
                case 2 -> { int p = ler("Percentual para abastecimento (15 a 70): "); System.out.println(safra.abastecer(a,p) ? "Abastecimento registrado." : "Percentual inválido."); }
                case 3 -> { int q = ler("Quantidade: "); System.out.println(bolsa.comprarGraos(a,q) ? "Compra concluída." : "Saldo insuficiente ou quantidade inválida."); }
                case 4 -> { int q = ler("Quantidade: "); System.out.println(bolsa.venderGraos(a,q) ? "Venda concluída." : "Estoque insuficiente."); }
                case 5 -> { int r = conselho.recolherTributo(a); System.out.println(r < 0 ? "Tributo já recolhido neste ano." : "Receita: " + r + " florins."); }
                case 6 -> { int t = ler("Nova taxa (0 a 30): "); System.out.println(conselho.alterarTaxa(a,t) ? "Taxa atualizada." : "Taxa inválida."); }
                case 7 -> System.out.println(obras.erguerEdificio(a) ? "Edifício construído." : "São necessários 120 florins.");
                case 8 -> { int q = ler("Quantidade de guardas: "); System.out.println(obras.formarGuarda(a,q) ? "Guarda formada." : "Recursos insuficientes."); }
                case 9 -> { if (temporada.avancarVez()) { temporada.fecharAno(); bolsa.atualizarMercado((a.getAno() % 2 == 0) ? 1 : -1); System.out.println("Ano encerrado. O mercado foi atualizado."); } }
                default -> System.out.println("Opção não reconhecida.");
            }
        }
        Assentamento vencedor = temporada.apontarVencedor();
        if (vencedor != null) System.out.println("\nResultado: " + vencedor.getNome() + " — " + vencedor.getResponsavel().getNome() + " / " + vencedor.getResponsavel().getPatente());
    }
    private int ler(String mensagem) { System.out.print(mensagem); try { return Integer.parseInt(entrada.nextLine().trim()); } catch (Exception e) { return -1; } }
}
