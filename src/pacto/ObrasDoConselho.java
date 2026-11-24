package pacto;

public class ObrasDoConselho {
    public boolean erguerEdificio(Assentamento a) {
        if (a == null || !a.pagar(120)) return false;
        a.adicionarEdificios(1); a.getResponsavel().somarInfluencia(35); return true;
    }
    public boolean formarGuarda(Assentamento a, int quantidade) {
        if (a == null || quantidade <= 0 || quantidade > 1000) return false;
        int custo = quantidade * 12;
        if (a.getHabitantes() < quantidade || !a.pagar(custo)) return false;
        a.alterarHabitantes(-quantidade); a.adicionarGuardas(quantidade); return true;
    }
}
