# ☕ Java — Fundamentos da JVM, JDK, JRE e Bytecode

Este README apresenta os principais conceitos necessários para entender **como o Java funciona por baixo dos panos**, incluindo JVM, JDK, JRE, bytecode, portabilidade, WORA e os principais componentes internos da JVM.

---

# 📚 Índice

* [O que é Java?](#-o-que-é-java)
* [Quem criou o Java?](#-quem-criou-o-java)
* [Orientação a Objetos (OO)](#-orientação-a-objetos-oo)
* [Portabilidade](#-portabilidade)
* [WORA](#-wora)
* [Como o Java funciona](#-como-o-java-funciona)
* [Bytecode](#-bytecode)
* [JVM](#-jvm)
* [Principais componentes da JVM](#-principais-componentes-da-jvm)
* [JRE](#-jre)
* [Componentes internos da JRE](#-componentes-internos-da-jre)
* [JDK](#-jdk)
* [JDK x JRE x JVM](#-jdk-x-jre-x-jvm)
* [Fluxo completo](#-fluxo-completo)
* [Resumo](#-resumo)

---

# ☕ O que é Java?

**Java** é uma linguagem de programação de propósito geral, criada com foco em:

* Orientação a Objetos;
* Portabilidade;
* Segurança;
* Robustez;
* Gerenciamento automático de memória;
* Desenvolvimento de aplicações desktop, web, mobile e servidores.

Java é muito utilizado no desenvolvimento **backend**, principalmente em sistemas corporativos, APIs, microsserviços e aplicações de grande escala.

Um dos conceitos mais importantes do Java é:

> **"Write Once, Run Anywhere"**

Ou seja:

> **Escreva uma vez e execute em qualquer lugar.**

Isso é possível principalmente por causa da **JVM (Java Virtual Machine)**.

---

# 👨‍💻 Quem criou o Java?

Java foi criado por uma equipe liderada por **James Gosling**, enquanto trabalhava na empresa **Sun Microsystems**.

O projeto começou no início da década de 1990 e originalmente se chamava **Oak**.

Posteriormente, a linguagem foi renomeada para **Java** e lançada publicamente em **1995**.

James Gosling é frequentemente conhecido como o **"pai do Java"**.

---

# 🧱 Orientação a Objetos (OO)

Java é uma linguagem fortemente associada ao paradigma de **Programação Orientada a Objetos (POO)**.

A ideia principal da orientação a objetos é organizar o software utilizando **objetos**, que representam entidades e comportamentos do sistema.

Por exemplo:

```java
public class Pessoa {

    String nome;
    int idade;

    void apresentar() {
        System.out.println("Olá, meu nome é " + nome);
    }
}
```

Podemos criar um objeto:

```java
Pessoa pessoa = new Pessoa();

pessoa.nome = "Ricardo";
pessoa.idade = 25;

pessoa.apresentar();
```

## Principais conceitos de POO

### Encapsulamento

Controla o acesso aos dados e comportamentos de um objeto.

### Herança

Permite que uma classe aproveite características de outra.

```java
class Animal {
    void emitirSom() {
        System.out.println("Som");
    }
}

class Cachorro extends Animal {
}
```

### Polimorfismo

Permite que diferentes objetos sejam tratados através de uma mesma interface ou abstração.

### Abstração

Esconde detalhes de implementação e expõe somente aquilo que é necessário.

---

# 🌎 Portabilidade

Portabilidade significa que um programa pode ser executado em diferentes sistemas operacionais e arquiteturas sem precisar ser completamente reescrito.

Por exemplo:

```text
Windows
Linux
macOS
```

Um programa Java pode ser compilado para **bytecode** e posteriormente executado em diferentes sistemas que possuam uma JVM compatível.

A ideia pode ser representada assim:

```text
Código Java
     ↓
Compilador
     ↓
Bytecode
     ↓
┌───────────────┐
│      JVM      │
└───────────────┘
   ↓     ↓     ↓
Windows Linux macOS
```

A JVM funciona como uma camada intermediária entre o programa Java e o sistema operacional.

---

# 🌍 WORA

**WORA** significa:

> **Write Once, Run Anywhere**

Em português:

> **Escreva uma vez, execute em qualquer lugar.**

É uma das características mais conhecidas do Java.

O conceito funciona porque o código Java não é compilado diretamente para código nativo de cada sistema operacional.

Primeiro ele é transformado em **bytecode**.

```text
Código Java
     ↓
  javac
     ↓
 Bytecode
     ↓
  .class
     ↓
    JVM
     ↓
Código nativo da máquina
```

Assim, o mesmo bytecode pode ser executado em diferentes sistemas que possuam uma implementação adequada da JVM.

---

# ⚙️ Como o Java funciona?

Quando escrevemos:

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Olá, Java!");
    }
}
```

Esse código não é executado diretamente pelo computador.

Primeiro precisamos compilá-lo.

```bash
javac Main.java
```

O compilador gera:

```text
Main.class
```

Esse arquivo contém **bytecode**.

Depois podemos executar:

```bash
java Main
```

A JVM carrega o bytecode e o executa.

---

# 🔢 Bytecode

**Bytecode** é o código intermediário produzido pelo compilador Java.

Quando executamos:

```bash
javac Main.java
```

o compilador transforma:

```text
Main.java
```

em:

```text
Main.class
```

O arquivo `.class` contém bytecode.

O bytecode não é diretamente o código de máquina específico do Windows, Linux ou macOS.

Ele é uma representação intermediária que a JVM consegue interpretar e/ou compilar para código nativo.

Podemos pensar assim:

```text
Java
 ↓
Bytecode
 ↓
JVM
 ↓
Código nativo
 ↓
CPU
```

---

# 🧠 JVM

**JVM** significa:

> **Java Virtual Machine**

Em português:

> **Máquina Virtual Java**

A JVM é responsável por executar o **bytecode Java**.

Ela é uma das partes fundamentais do ecossistema Java.

A JVM cria uma camada de abstração entre a aplicação Java e o sistema operacional.

Por exemplo:

```text
             Aplicação Java
                   ↓
               Bytecode
                   ↓
        ┌────────────────────┐
        │        JVM         │
        ├────────────────────┤
        │ Class Loader       │
        │ Runtime Data Area  │
        │ Execution Engine   │
        │ Garbage Collector  │
        │ JNI                │
        │ Native Libraries   │
        └────────────────────┘
                   ↓
          Sistema Operacional
                   ↓
                   CPU
```

---

# 🔧 Principais componentes da JVM

Os principais componentes conceituais da JVM são:

1. **Class Loader**
2. **Runtime Data Areas**
3. **Execution Engine**
4. **Garbage Collector**
5. **JNI**
6. **Native Method Libraries**

---

## 1. Class Loader

O **Class Loader** é responsável por carregar classes Java para a memória da JVM.

Por exemplo:

```java
Pessoa pessoa = new Pessoa();
```

A JVM precisa encontrar e carregar a classe `Pessoa`.

O processo envolve etapas como:

```text
Carregamento
     ↓
Linking
     ↓
Inicialização
```

### Class Loaders

Existem diferentes carregadores de classes, incluindo:

* Bootstrap Class Loader
* Platform Class Loader
* Application Class Loader

---

# 2. Runtime Data Areas

São áreas de memória utilizadas durante a execução da aplicação.

Entre elas estão:

* Heap
* JVM Stack
* Method Area
* PC Register
* Native Method Stack

---

## Heap

O **Heap** é uma região de memória utilizada principalmente para armazenar objetos criados durante a execução.

Exemplo:

```java
Pessoa pessoa = new Pessoa();
```

O objeto `Pessoa` é alocado no Heap.

O Garbage Collector trabalha principalmente sobre essa região.

---

## JVM Stack

Cada thread possui sua própria **JVM Stack**.

Ela armazena informações relacionadas às chamadas de métodos.

Por exemplo:

```java
public static void main(String[] args) {
    calcular();
}

static void calcular() {
    int valor = 10;
}
```

Durante a execução, cada chamada de método possui um **stack frame**.

---

## Method Area

Armazena informações relacionadas às classes carregadas, como:

* Estrutura das classes;
* Métodos;
* Campos;
* Constantes;
* Informações de runtime.

Nas JVMs modernas, a implementação dessa área possui particularidades. Por exemplo, no HotSpot, metadados de classes são armazenados no **Metaspace**.

---

## PC Register

**PC** significa:

> Program Counter

Cada thread possui um PC Register que mantém informações sobre a instrução que está sendo executada.

---

## Native Method Stack

É utilizada para suportar a execução de métodos nativos.

Métodos nativos são métodos implementados em linguagens como C ou C++ e acessados pela JVM através de mecanismos como JNI.

---

# ⚡ Execution Engine

O **Execution Engine** é responsável por executar o bytecode.

Entre seus mecanismos estão:

### Interpreter

O interpretador executa instruções de bytecode.

Isso permite que o programa comece a executar rapidamente.

---

### JIT Compiler

**JIT** significa:

> Just-In-Time Compiler

O JIT identifica partes do código que são executadas frequentemente e pode compilá-las para código nativo durante a execução.

Isso permite melhorar o desempenho.

Podemos representar:

```text
Bytecode
   ↓
Interpreter
   ↓
Execução

Bytecode frequentemente executado
   ↓
JIT Compiler
   ↓
Código nativo
   ↓
Execução otimizada
```

---

# ♻️ Garbage Collector

O **Garbage Collector (GC)** é responsável por gerenciar automaticamente grande parte da memória utilizada por objetos que não são mais necessários.

Por exemplo:

```java
Pessoa pessoa = new Pessoa();

pessoa = null;
```

Se não houver mais referências para determinado objeto, ele pode se tornar elegível para coleta pelo Garbage Collector.

Isso reduz a necessidade de liberar manualmente a memória.

Java, portanto, possui **gerenciamento automático de memória**, embora isso não signifique que o desenvolvedor possa ignorar completamente questões de memória e performance.

---

# 🔌 JNI

**JNI** significa:

> **Java Native Interface**

É uma interface que permite que código Java interaja com código nativo.

Por exemplo:

```text
Java
 ↓
JNI
 ↓
C / C++
 ↓
Sistema Operacional
```

É utilizado quando uma aplicação precisa interagir com recursos nativos ou bibliotecas específicas.

---

# 📦 Native Method Libraries

São bibliotecas nativas utilizadas pela JVM para executar determinadas operações específicas da plataforma.

Podem envolver código nativo, como C/C++, dependendo da implementação e do sistema operacional.

---

# 🧰 JRE

**JRE** significa:

> **Java Runtime Environment**

Em português:

> **Ambiente de Execução Java**

O JRE fornece o ambiente necessário para **executar aplicações Java**.

De forma conceitual:

```text
JRE
├── JVM
├── Bibliotecas Java
└── Componentes necessários para execução
```

O JRE é voltado para **executar** aplicações.

---

# 🔩 Componentes internos da JRE

De forma conceitual, podemos visualizar o JRE assim:

```text
JRE
│
├── JVM
│   ├── Class Loader
│   ├── Runtime Data Areas
│   ├── Execution Engine
│   ├── Garbage Collector
│   ├── JNI
│   └── Native Libraries
│
└── Java Runtime Libraries
    ├── java.lang
    ├── java.util
    ├── java.io
    ├── java.net
    ├── java.time
    └── outras APIs
```

### JVM

Executa o bytecode.

### Java Runtime Libraries

Fornecem funcionalidades prontas da plataforma Java.

Exemplos:

```java
String
System
List
ArrayList
LocalDate
File
Socket
```

---

# 🛠️ JDK

**JDK** significa:

> **Java Development Kit**

Em português:

> **Kit de Desenvolvimento Java**

É utilizado para **desenvolver aplicações Java**.

Ele fornece ferramentas para escrever, compilar, executar, testar e diagnosticar aplicações.

Podemos pensar:

```text
JDK
│
├── Ferramentas de desenvolvimento
│   ├── javac
│   ├── java
│   ├── javadoc
│   ├── jar
│   └── outras ferramentas
│
└── Runtime
    └── JVM + bibliotecas necessárias
```

---

# 🔨 Principais ferramentas do JDK

## javac

Compilador Java.

```bash
javac Main.java
```

Transforma:

```text
Main.java
```

em:

```text
Main.class
```

---

## java

Executa uma aplicação Java.

```bash
java Main
```

---

## jar

Permite trabalhar com arquivos JAR.

```bash
jar
```

JAR significa:

> **Java ARchive**

É utilizado para empacotar classes e outros recursos.

---

## javadoc

Gera documentação a partir de comentários/documentação presentes no código Java.

---

# 🆚 JDK x JRE x JVM

Essa é uma das diferenças mais importantes para quem está começando.

| Componente | Função                                             |
| ---------- | -------------------------------------------------- |
| **JVM**    | Executa o bytecode                                 |
| **JRE**    | Ambiente necessário para executar aplicações Java  |
| **JDK**    | Ambiente completo para desenvolver aplicações Java |

Uma forma simples de memorizar:

```text
JDK
│
├── Ferramentas de desenvolvimento
│
└── Runtime
    │
    └── JVM
```

### Em termos simples:

**JVM**

> "Eu executo o bytecode."

**JRE**

> "Eu forneço o ambiente necessário para executar Java."

**JDK**

> "Eu forneço as ferramentas necessárias para desenvolver Java."

---

# ⚠️ Uma observação importante sobre versões modernas do Java

Em versões modernas do Java, como as versões atuais do JDK, a distribuição padrão do JDK é o principal pacote utilizado pelos desenvolvedores.

O antigo conceito de instalar separadamente um **JRE** como produto independente não deve ser confundido com a arquitetura conceitual.

Por isso, atualmente, quando você vai desenvolver Java, normalmente instala diretamente um **JDK**.

---

# 🔄 Fluxo completo do Java

Podemos resumir todo o processo desta maneira:

```text
              Código-fonte
              Main.java
                   │
                   ▼
             ┌───────────┐
             │   javac   │
             │ Compilador│
             └─────┬─────┘
                   │
                   ▼
              Bytecode
              Main.class
                   │
                   ▼
             ┌───────────┐
             │    JVM    │
             └─────┬─────┘
                   │
          ┌────────┴────────┐
          ▼                 ▼
    Class Loader       Runtime Data
                            Areas
          │                 │
          └────────┬────────┘
                   ▼
           Execution Engine
                   │
            ┌──────┴──────┐
            ▼             ▼
       Interpreter       JIT
            │             │
            └──────┬──────┘
                   ▼
             Código nativo
                   │
                   ▼
                  CPU
```

---

# 🧠 Exemplo prático

Imagine este código:

```java
public class Main {

    public static void main(String[] args) {

        int numero = 10;

        System.out.println(numero);
    }
}
```

### 1. Código-fonte

Criamos:

```text
Main.java
```

### 2. Compilação

Executamos:

```bash
javac Main.java
```

### 3. Bytecode

É criado:

```text
Main.class
```

### 4. Execução

Executamos:

```bash
java Main
```

### 5. JVM

A JVM:

* carrega a classe;
* verifica o bytecode;
* organiza os dados na memória;
* executa as instruções;
* utiliza o Interpreter e/ou JIT;
* gerencia memória através do Garbage Collector.

---

# 🗺️ Visão geral

Uma maneira fácil de visualizar todo o ecossistema:

```text
                         JDK
                          │
          ┌───────────────┴───────────────┐
          │                               │
 Ferramentas de desenvolvimento       Runtime
          │                               │
     javac, jar...                       │
                                          ▼
                                         JRE
                                          │
                         ┌────────────────┴───────────────┐
                         │                               │
                        JVM                     Bibliotecas Java
                         │
             ┌───────────┼────────────┐
             │           │            │
        Class Loader   Memory      Execution
                       Areas        Engine
                                     │
                              ┌──────┴──────┐
                              │             │
                         Interpreter       JIT
                              │             │
                              └──────┬──────┘
                                     ▼
                                Código nativo
                                     │
                                     ▼
                                    CPU
```

---

# 📌 Resumo para memorizar

### Java

É a linguagem de programação.

### POO / OO

Paradigma baseado em objetos, classes, encapsulamento, herança, polimorfismo e abstração.

### Portabilidade

Capacidade de executar uma aplicação em diferentes plataformas.

### WORA

**Write Once, Run Anywhere.**

Escreva uma vez e execute em qualquer lugar que possua uma plataforma Java compatível.

### Bytecode

Código intermediário produzido pelo compilador Java.

```text
.java → .class
```

### JVM

Máquina virtual responsável por executar o bytecode.

### JRE

Ambiente de execução que, conceitualmente, reúne a JVM e as bibliotecas necessárias para executar aplicações Java.

### JDK

Kit utilizado para desenvolver aplicações Java.

```text
JDK
 ↓
desenvolvimento

JRE
 ↓
execução

JVM
 ↓
executa bytecode
```

---

# 🎯 O que você precisa decorar neste primeiro momento?

Se você está começando Java para backend, foque primeiro nestes conceitos:

```text
Java
 │
 ├── POO
 │
 ├── Portabilidade
 │
 ├── WORA
 │
 ├── Bytecode
 │
 ├── JVM
 │
 ├── JRE
 │
 └── JDK
```

E principalmente:

```text
.java
  ↓
javac
  ↓
.class (Bytecode)
  ↓
JVM
  ↓
Código nativo
  ↓
CPU
```

Essa sequência é fundamental para entender **por que Java é portátil** e como uma aplicação Java consegue ser executada em diferentes sistemas operacionais.
