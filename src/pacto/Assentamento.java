package pacto;

public class Assentamento {
    private final String nome;
    private final Participante responsavel;
    private int florins = 850, hectares = 720, graos = 260, habitantes = 140;
    private int guardas, edificios, imposto = 8, ano = 1400;
    private boolean safraFeita, tributoRecolhido;

    public Assentamento(String nome, Participante responsavel) {
        if (nome == null || nome.isBlank() || responsavel == null) throw new IllegalArgumentException("Dados do assentamento inválidos.");
        this.nome = nome; this.responsavel = responsavel;
    }
    public String getNome() { return nome; } public Participante getResponsavel() { return responsavel; }
    public int getFlorins() { return florins; } public int getHectares() { return hectares; }
    public int getGraos() { return graos; } public int getHabitantes() { return habitantes; }
    public int getGuardas() { return guardas; } public int getEdificios() { return edificios; }
    public int getImposto() { return imposto; } public int getAno() { return ano; }
    public boolean isSafraFeita() { return safraFeita; } public boolean isTributoRecolhido() { return tributoRecolhido; }
    public void definirImposto(int valor) { if (valor >= 0 && valor <= 30) imposto = valor; }
    public boolean pagar(int valor) { if (valor <= 0 || valor > florins) return false; florins -= valor; return true; }
    public void receber(int valor) { if (valor > 0) florins += valor; }
    public boolean gastarGraos(int valor) { if (valor <= 0 || valor > graos) return false; graos -= valor; return true; }
    public void guardarGraos(int valor) { if (valor > 0) graos += valor; }
    public boolean negociarTerras(int hectares) { if (hectares <= 0 || hectares > florins / 3) return false; pagar(hectares * 3); this.hectares += hectares; return true; }
    public void alterarHabitantes(int valor) { habitantes = Math.max(0, habitantes + valor); }
    public void adicionarGuardas(int qtd) { guardas += Math.max(0, qtd); }
    public void adicionarEdificios(int qtd) { edificios += Math.max(0, qtd); }
    public void marcarSafra() { safraFeita = true; }
    public void marcarTributo() { tributoRecolhido = true; }
    public void iniciarNovoAno() { ano++; safraFeita = false; tributoRecolhido = false; }
    public void exibirPainel() {
        System.out.printf("%n=== %s | %d ===%nResponsável: %s (%s)%nFlorins: %d | Terras: %d ha | Grãos: %d%nHabitantes: %d | Guardas: %d | Edifícios: %d | Tributo: %d%%%n",
                nome, ano, responsavel.getNome(), responsavel.getPatente(), florins, hectares, graos, habitantes, guardas, edificios, imposto);
    }
}
