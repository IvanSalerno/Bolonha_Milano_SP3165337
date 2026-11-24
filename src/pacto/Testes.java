package pacto;

public class Testes {
    private static int ok, falhas;
    public static void main(String[] args) {
        Participante p = new Participante("Ada"); Assentamento a = new Assentamento("Bolonha", p);
        conferir("recursos iniciais", a.getFlorins() == 850 && a.getGraos() == 260);
        conferir("não permite saldo negativo", !a.pagar(900) && a.getFlorins() == 850);
        conferir("compra de terras", a.negociarTerras(10) && a.getHectares() == 730);
        Safra s = new Safra(); int colheita = s.colher(a);
        conferir("colheita gera excedente", colheita > 0);
        conferir("não repete safra no mesmo ano", s.colher(a) == -1);
        conferir("abastecimento rejeita percentual inválido", !s.abastecer(a, 90));
        BolsaDeTrocas b = new BolsaDeTrocas();
        conferir("compra de grãos", b.comprarGraos(a, 10) && a.getGraos() >= 10);
        conferir("venda exige estoque", !b.venderGraos(a, 99999));
        Conselho c = new Conselho();
        conferir("taxa dentro do limite", c.alterarTaxa(a, 12) && a.getImposto() == 12);
        conferir("taxa acima do limite recusada", !c.alterarTaxa(a, 40));
        conferir("tributo recolhido uma vez", c.recolherTributo(a) >= 0 && c.recolherTributo(a) == -1);
        ObrasDoConselho o = new ObrasDoConselho();
        conferir("construção respeita custo", o.erguerEdificio(a) && a.getEdificios() == 1);
        conferir("guarda não pode exceder habitantes", !o.formarGuarda(a, 9999));
        Temporada t = new Temporada(); t.inscrever(a); Assentamento m = new Assentamento("Milano", new Participante("Bruno")); t.inscrever(m);
        conferir("ordem de turnos", t.getAssentamentoDaVez() == a && !t.avancarVez() && t.getAssentamentoDaVez() == m);
        conferir("fim da rodada", t.avancarVez()); t.fecharAno();
        conferir("ano avança para todos", a.getAno() == 1401 && m.getAno() == 1401);
        conferir("vencedor é definido", t.apontarVencedor() != null);
        System.out.println("\nTestes aprovados: " + ok + " | Falhas: " + falhas);
        if (falhas > 0) System.exit(1);
    }
    private static void conferir(String nome, boolean condicao) { if (condicao) { ok++; System.out.println("[OK] " + nome); } else { falhas++; System.out.println("[FALHA] " + nome); } }
}
