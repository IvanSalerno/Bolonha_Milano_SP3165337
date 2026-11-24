# Pacto das Duas Cidades

**Bolonha e Milano — jogo de estratégia econômica em Java**

Esta implementação foi criada do zero, com arquitetura, nomes de classes, fluxo de terminal e regras complementares próprios. A proposta é administrar um assentamento ligado a uma das duas cidades, equilibrando produção agrícola, abastecimento, comércio, tributos, obras públicas e segurança.

## Conceito e objetivo

Cada participante administra um assentamento e tenta ampliar sua influência política. A partida percorre anos; em cada rodada, os participantes realizam ações e, ao fim da volta, o calendário avança. A progressão de influência libera patentes: Regente, Conselheiro, Lorde, Duque e Soberano. A disputa termina quando alguém alcança o título máximo ou quando o calendário ultrapassa 1420.

## Requisitos

- Java 17 ou superior.
- Nenhuma biblioteca externa.
- Terminal compatível com UTF-8.

## Compilar e executar

Na raiz do projeto:

```bash
javac -encoding UTF-8 -d out src/pacto/*.java
java -cp out pacto.Main
```

Executar os testes automatizados:

```bash
java -cp out pacto.Testes
```

## Organização

| Caminho | Responsabilidade |
|---|---|
| `src/pacto/Main.java` | Configuração e inicialização da partida |
| `src/pacto/Participante.java` | Identidade, influência e progressão política |
| `src/pacto/Assentamento.java` | Estado econômico e populacional do território |
| `src/pacto/Safra.java` | Colheita e abastecimento dos habitantes |
| `src/pacto/BolsaDeTrocas.java` | Compra, venda e preço dos grãos |
| `src/pacto/Conselho.java` | Tributos e definição da taxa |
| `src/pacto/ObrasDoConselho.java` | Construções e formação da guarda |
| `src/pacto/Temporada.java` | Participantes, turnos, passagem dos anos e vencedor |
| `src/pacto/ConsoleJogo.java` | Interface de interação no terminal |
| `src/pacto/Testes.java` | Verificações automatizadas das regras principais |
| `uml/` | Diagramas de classes e sequência |
| `casos-de-uso/` | Visão das ações disponíveis ao participante |

## Etapas do projeto e correspondência com a avaliação

1. Inicialização do programa e configuração dos participantes (`Main`, `ConsoleJogo`).
2. Modelagem de participantes e assentamentos (`Participante`, `Assentamento`).
3. Gestão de florins, terras e grãos (`Assentamento`, `BolsaDeTrocas`).
4. Produção agrícola e abastecimento (`Safra`).
5. Administração pública e tributos (`Conselho`).
6. Obras, edifícios e guardas (`ObrasDoConselho`).
7. Rodadas com múltiplos participantes, calendário e condição de vitória (`Temporada`).
8. Integração, testes, documentação e diagramas.

> A lista descreve a organização funcional do código final. O histórico de commits e as tags de cada etapa devem ser criados no Git durante o desenvolvimento real; não são simulados neste arquivo compactado.

## Regras principais

- São aceitos de dois a quatro participantes.
- Cada assentamento inicia com 850 florins, 720 hectares, 260 grãos e 140 habitantes.
- A colheita pode ser realizada uma vez por ano.
- O abastecimento aceita percentuais entre 15% e 70% do estoque de grãos.
- A taxa de tributo pode variar de 0% a 30%, e a arrecadação ocorre uma vez por ano.
- Uma construção custa 120 florins. Cada guarda custa 12 florins e consome um habitante disponível.
- A bolsa de trocas altera o preço dos grãos no fechamento de cada ano.
- A influência acumulada permite avançar entre as patentes políticas.

## Diagramas

Os arquivos `.puml` podem ser abertos no PlantUML. Os diagramas representam a arquitetura desta implementação, não a do projeto de referência.
