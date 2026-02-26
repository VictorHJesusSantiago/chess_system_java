<div align="center">

<img src="https://cdn-icons-png.flaticon.com/512/1165/1165163.png" alt="Chess Logo" width="110" />

# ♞ Sistema de Xadrez — Java

**Um jogo de xadrez completo em Java, focado em uma arquitetura de camadas robusta**
**e lógica de jogo precisa, jogado inteiramente no console.**

<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/Apache%20NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigma-OOP-blueviolet?style=for-the-badge)
![Console](https://img.shields.io/badge/Interface-Console-555555?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completo-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

</div>

---

## 📚 Tabela de Conteúdos

> Navegue rapidamente pelas seções do projeto.

| # | Seção |
|:-:|:------|
| 1 | [📖 Sobre o Projeto](#-sobre-o-projeto) |
| 2 | [🖥️ Demonstração no Console](#️-demonstração-no-console) |
| 3 | [✨ Funcionalidades](#-funcionalidades) |
| 4 | [📦 Arquitetura do Projeto](#-arquitetura-do-projeto) |
| 5 | [🛠️ Tecnologias Utilizadas](#️-tecnologias-utilizadas) |
| 6 | [🚀 Como Executar](#-como-executar) |
| 7 | [🤝 Como Contribuir](#-como-contribuir) |
| 8 | [👨‍💻 Autor](#-autor) |
| 9 | [📄 Licença](#-licença) |

---

## 📖 Sobre o Projeto

> **Sistema de Xadrez** é uma implementação completa de um jogo de xadrez em console com Java. O foco principal não é a interface gráfica, mas sim a criação de um sistema **coeso, bem estruturado e com lógica de jogo precisa**.

O projeto foi desenhado com separação de responsabilidades em **duas camadas independentes**: uma camada genérica de jogo de tabuleiro (reutilizável) e uma camada específica de xadrez com todas as regras de negócio — demonstrando na prática os princípios de **Herança**, **Abstração** e **Encapsulamento** da Orientação a Objetos.

---

## 🖥️ Demonstração no Console

```
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
```

> As peças **maiúsculas** representam as pretas (`BLACK`) e as **minúsculas** representam as brancas (`WHITE`). A entrada é feita no formato padrão de xadrez: coluna (a–h) + linha (1–8).

---

## ✨ Funcionalidades

### ♟️ Regras Padrão

| Ícone | Funcionalidade | Descrição |
|:-----:|:---------------|:----------|
| 🗺️ | **Impressão do Tabuleiro** | Interface de console (`UI.java`) que redesenha o tabuleiro após cada jogada. |
| 🎯 | **Movimentação de Peças** | Aceita entrada no formato de xadrez (ex: `e2` → `e4`). |
| ✅ | **Validação de Movimentos** | Calcula e exibe os movimentos possíveis, impedindo jogadas ilegais. |
| ⚔️ | **Capturas** | Lógica completa para capturar peças do oponente. |
| 🔄 | **Sistema de Turnos** | Controla qual cor (Brancas ou Pretas) deve jogar em cada turno. |
| ♚ | **Detecção de Xeque** | Identifica e sinaliza quando um Rei está em xeque. |
| 🏁 | **Detecção de Xeque-Mate** | Encerra o jogo quando um Xeque-Mate é alcançado. |

### ⭐ Regras Especiais Implementadas

| Regra Especial | Arquivo de Implementação |
|:---------------|:------------------------:|
| ♜ **Roque Pequeno e Grande** | `King.java` |
| ⬡ **En Passant** | `Pawn.java` + `ChessMatch.java` |
| 👑 **Promoção de Peão** | `ChessMatch.java` *(promove para Rainha por padrão)* |

---

## 📦 Arquitetura do Projeto

> O design em **duas camadas independentes** é o conceito central do projeto.

```
┌─────────────────────────────────────────────────┐
│             CAMADA DE XADREZ (chess)             │
│   Regras específicas do xadrez — herda boardgame │
│  ChessMatch · ChessPiece · ChessPosition · Color  │
│  Bishop · King · Knight · Pawn · Queen · Rook    │
└───────────────────┬─────────────────────────────┘
                    │ herda / implementa
┌───────────────────▼─────────────────────────────┐
│         CAMADA GENÉRICA (boardgame)              │
│  Abstração de qualquer jogo de tabuleiro         │
│       Board · Piece · Position                   │
└─────────────────────────────────────────────────┘
```

### 🗂️ Descrição dos Pacotes

| Pacote / Arquivo | Classe | Responsabilidade |
|:-----------------|:------:|:-----------------|
| *(default)* | `Program.java` | Ponto de entrada — inicia o jogo e contém o **loop principal** da partida. |
| *(default)* | `UI.java` | Toda a interação com o console: imprime tabuleiro, lê entradas e limpa a tela. |
| `boardgame` | `Board.java` | Tabuleiro genérico (matriz de peças). Não conhece nada sobre xadrez. |
| `boardgame` | `Piece.java` | Classe **abstrata** para uma peça genérica de tabuleiro. |
| `boardgame` | `Position.java` | Representa uma posição (linha e coluna) na matriz interna. |
| `boardgame` | `BoardException.java` | Exceção personalizada para erros de tabuleiro. |
| `chess` | `ChessMatch.java` | ❤️ **O coração do jogo.** Controla partida, turnos, regras especiais e estado. |
| `chess` | `ChessPiece.java` | Classe **abstrata** para peça de xadrez — adiciona a cor (`Color`). |
| `chess` | `ChessPosition.java` | Converte posições de matriz (`0,0`) para notação de xadrez (`a8`). |
| `chess` | `Color.java` | `enum` com os valores `BLACK` e `WHITE`. |
| `chess` | `ChessException.java` | Exceção personalizada para erros de regras de xadrez. |
| `chess.pieces` | `Bishop · King · Knight` | Classes concretas de peças com sua lógica de `possibleMoves()`. |
| `chess.pieces` | `Pawn · Queen · Rook` | Classes concretas de peças com sua lógica de `possibleMoves()`. |

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Função no Projeto |
|:-----------|:------------------|
| **Java** | Linguagem principal — toda a lógica, arquitetura e regras do jogo. |
| **Apache NetBeans** | IDE utilizada no desenvolvimento (arquivos `nbproject/` incluídos). |
| **OOP (Herança, Abstração, Encapsulamento)** | Paradigma central que estrutura as duas camadas do projeto. |

---

## 🚀 Como Executar

### 📋 Pré-requisitos

| Requisito | Detalhe |
|:----------|:--------|
| **JDK** | Versão **11 ou superior** instalada e configurada no `PATH`. |
| **Apache NetBeans** *(opcional)* | Recomendado para execução direta. |
| **Git** | Para clonar o repositório. |

---

### ▶️ Opção 1 — Apache NetBeans (Recomendado)

```
1. Abra o Apache NetBeans IDE
2. File → Open Project...
3. Selecione a pasta raiz do projeto (chess_system_java-main)
4. Clique em "Run Project" ou pressione F6
```

> A IDE compila e executa `Program.java` automaticamente no terminal de saída.

---

### 💻 Opção 2 — Terminal (Manual)

**1. Clone o repositório e acesse a pasta `src/`:**

```bash
git clone https://github.com/VictorHJesusSantiago/chess_system_java.git
cd chess_system_java/src
```

**2. Compile todos os arquivos `.java`:**

```bash
# Linux / macOS
javac Program.java UI.java boardgame/*.java chess/*.java chess/pieces/*.java

# Windows
javac Program.java UI.java boardgame\*.java chess\*.java chess\pieces\*.java
```

**3. Execute a partir da pasta `src/`:**

```bash
java Program
```

---

### 🎮 Como Jogar

| Passo | Instrução |
|:-----:|:----------|
| 1️⃣ | O tabuleiro é impresso no console com a posição inicial das peças. |
| 2️⃣ | Digite a **origem** do movimento no formato `coluna + linha` (ex: `e2`). |
| 3️⃣ | Os movimentos possíveis são destacados no tabuleiro. |
| 4️⃣ | Digite o **destino** do movimento (ex: `e4`). |
| 5️⃣ | O turno passa para o adversário. Repita até o Xeque-Mate. |

---

## 🤝 Como Contribuir

> Contribuições são muito bem-vindas! Siga as etapas abaixo para colaborar de forma organizada.

| Passo | Ação | Comando |
|:-----:|:-----|:--------|
| 1️⃣ | **Fork** | Crie um fork do repositório para a sua conta. | — |
| 2️⃣ | **Branch** | Crie sua feature branch a partir da `main`. | `git checkout -b feature/NovaFeature` |
| 3️⃣ | **Commit** | Salve as alterações com mensagem clara e semântica. | `git commit -m 'feat: Adiciona NovaFeature'` |
| 4️⃣ | **Push** | Envie a branch para o repositório remoto. | `git push origin feature/NovaFeature` |
| 5️⃣ | **Pull Request** | Abra um PR detalhando as mudanças realizadas. | — |

<div align="center">

<br>

**Se este projeto foi útil para os seus estudos, deixe uma estrela ⭐️ no repositório!**

</div>

---

## 👨‍💻 Autor

<div align="center">

<br>

**Victor H. J. Santiago**

<br>

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/VictorHJesusSantiago)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/victor-henrique-de-jesus-santiago/)

</div>

---

## 📄 Licença

<div align="center">

Este projeto está distribuído sob a **Licença MIT**.
Consulte o arquivo [`LICENSE`](./LICENSE) no repositório para mais informações.

![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

</div>

---

<div align="center">

*Feito com ♟️ e Java por **Victor H. J. Santiago***

</div>
