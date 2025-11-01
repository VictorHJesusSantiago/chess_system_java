<div align="center">

♞ Sistema de Xadrez (Java) ♞

Um jogo de xadrez completo em Java, focado em uma arquitetura de camadas e lógica de jogo robusta, jogado inteiramente no console.

</div>

<p align="center"> <img alt="Status do Projeto" src="https://img.shields.io/badge/Status-Completo-brightgreen?style=for-the-badge"> <img alt="Linguagem" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"> <img alt="IDE" src="https://img.shields.io/badge/IDE-Apache%20NetBeans-blueviolet?style=for-the-badge&logo=apache-netbeans-ide"> </p>

<div align="center">

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Demonstração da Interface do Console

  a b c d e f g h
  
8 R N B Q K B N R

7 P P P P P P P P

6 - - - - - - - -

5 - - - - - - - -

4 - - - - - - - -

3 - - - - - - - -

2 p p p p p p p p

1 r n b q k b n r

  a b c d e f g h

Turn : 1

Waiting player: WHITE

Source: e2

Target: e4
</div>

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📖 Sobre o Projeto

Este projeto é uma implementação de um jogo de xadrez de console em Java. O foco principal não é a interface gráfica, mas sim a criação de um sistema coeso, bem estruturado e com lógica de jogo precisa.

O design do projeto é dividido em duas camadas principais:

Camada Genérica (boardgame): Contém classes abstratas para um "jogo de tabuleiro" genérico, como Board, Piece, e Position. Esta camada não sabe nada sobre xadrez.

Camada de Xadrez (chess): Contém as regras de negócio e a lógica específica do xadrez. Ela herda e implementa as classes da camada boardgame, adicionando regras para ChessMatch, ChessPiece, e as peças individuais (Peão, Torre, Rei, etc.).

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
✨ Funcionalidades

Lógica Completa de Xadrez: Implementa todas as regras padrão do xadrez.

Impressão de Tabuleiro: Uma interface de console (UI.java) que imprime o tabuleiro de forma clara após cada jogada.

Movimentação de Peças: Aceita entradas do utilizador no formato de xadrez (ex: "e2" para "e4").

Validação de Movimentos: Calcula e valida os movimentos possíveis para cada peça, impedindo jogadas ilegais.

Capturas de Peças: Lógica para capturar peças do oponente.

Sistema de Turnos: Controla qual cor (Brancas ou Pretas) deve jogar.

Regras Especiais Implementadas:

Roque (Pequeno e Grande) (King.java).

En Passant (Pawn.java e ChessMatch.java).

Promoção (atualmente promove para Rainha por padrão) (ChessMatch.java).

Detecção de Xeque (Check): O sistema identifica quando um Rei está em xeque (ChessMatch.java).

Detecção de Xeque-Mate (Checkmate): O jogo termina quando um Xeque-Mate é alcançado (ChessMatch.java).

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📦 Arquitetura do Projeto

A estrutura de pacotes é a chave para entender este projeto:

1. Program.java (default package): A classe principal que inicia o jogo e contém o loop principal da partida.

2. UI.java (default package): Classe responsável por toda a interação com o console (imprimir o tabuleiro, ler e2ntradas, limpar a tela).

3. boardgame (pacote):

Board.java: Representa o tabuleiro genérico (matriz de peças).

Piece.java: Classe abstrata para uma peça genérica.

Position.java: Representa uma posição (linha e coluna) na matriz.

BoardException.java: Exceção personalizada para erros do tabuleiro.

4. chess (pacote):

ChessMatch.java: O "coração" do jogo. Controla a partida, turnos, regras especiais e o estado do jogo.

ChessPiece.java: Classe abstrata para uma peça de xadrez (adiciona a cor).

ChessPosition.java: Converte posições de matriz (ex: 0,0) para posições de xadrez (ex: a8).

Color.java: Enum para BLACK e WHITE.

ChessException.java: Exceção personalizada para erros de xadrez.

5. chess.pieces (sub-pacote):

Contém as classes concretas para cada peça (Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java), cada uma com sua própria lógica de movimentos possíveis (possibleMoves()).

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🛠️ Tecnologias Utilizadas

Java (linguagem principal)

Apache NetBeans (Ambiente de Desenvolvimento Integrado, indicado pelos arquivos nbproject/)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💿 Como Executar

Opção 1: Pela IDE Apache NetBeans (Recomendado)

Como este é um projeto NetBeans, a forma mais fácil de o executar é:

Abra o Apache NetBeans IDE.

Vá para File > Open Project...

Selecione a pasta raiz do projeto (chess_system_java-main).

Clique no botão "Run Project" (ou prima F6). A IDE irá compilar e executar a classe Program.java automaticamente no seu terminal de saída.

Opção 2: Compilando e Executando via Terminal

Se não estiver a usar o NetBeans, pode compilar e executar o projeto manualmente:

Clone o repositório e navegue até à pasta src/: git clone https://github.com/victorhjsantiago/chess_system_java.git

cd chess_system_java/src

Compile todos os ficheiros .java (o * inclui os subdiretórios):

# No Linux/macOS
javac Program.java UI.java boardgame/*.java chess/*.java chess/pieces/*.java

# No Windows (use '\' como separador)
javac Program.java UI.java boardgame\*.java chess\*.java chess\pieces\*.java

Execute a classe principal (a partir da pasta src/): java Program
