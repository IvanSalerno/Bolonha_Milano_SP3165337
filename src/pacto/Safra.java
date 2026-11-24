package pacto;

public class Safra {
    public int colher(Assentamento a) {
        if (a == null || a.isSafraFeita()) return -1;
        int area = Math.min(a.getHectares(), a.getHabitantes() * 4);
        int sementes = Math.min(a.getGraos(), (area + 3) / 4);
        if (area == 0 || sementes == 0) return 0;
        a.gastarGraos(sementes);
        int producao = sementes * 5;
        a.guardarGraos(producao);
        a.marcarSafra();
        return producao - sementes;
    }
    public boolean abastecer(Assentamento a, int percentual) {
        if (a == null || percentual < 15 || percentual > 70) return false;
        int reservado = a.getGraos() * percentual / 100;
        int necessidade = Math.max(1, a.getHabitantes() / 12);
        a.gastarGraos(reservado);
        if (reservado >= necessidade) a.alterarHabitantes(Math.max(1, a.getHabitantes() / 25));
        else a.alterarHabitantes(-Math.min(a.getHabitantes(), necessidade - reservado));
        return true;
    }
}
