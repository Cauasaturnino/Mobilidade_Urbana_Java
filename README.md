\# 🚲 Sistema de Locação de Mobilidade Urbana



Sistema em Java para locação de bicicletas e patinetes elétricos entre estações,

desenvolvido como atividade prática (APS) de Linguagem de Programação Orientada a Objetos

no curso de Análise e Desenvolvimento de Sistemas, Unifametro.



\## Funcionalidades



\- Cadastro de usuários, estações e veículos

\- Locação de veículo somente na estação em que ele está

\- Bloqueio de locação para veículo indisponível ou usuário com locação ativa

\- Devolução em qualquer estação cadastrada

\- Cálculo de tarifa por minuto (bicicleta: R$ 0,10 | patinete elétrico: R$ 0,20)

\- Recarga de bateria dos patinetes elétricos



\## Conceitos de POO aplicados



\- \*\*Herança e classe abstrata\*\*: `Veiculo` → `Bicicleta`, `PatineteEletrico`

\- \*\*Polimorfismo\*\*: cada veículo implementa o próprio `calcularTarifa`

\- \*\*Interface\*\*: `Recarregavel`, implementada pelo patinete

\- \*\*Encapsulamento\*\*: atributos privados acessados por métodos



\## Estrutura do projeto



```

src/br/com/mobilidade/

├── Main.java

├── modelo/

│   ├── Veiculo.java

│   ├── Bicicleta.java

│   ├── PatineteEletrico.java

│   ├── Recarregavel.java

│   ├── Usuario.java

│   ├── Estacao.java

│   └── Locacao.java

└── servico/

&#x20;   └── SistemaLocacao.java

```



\## Como executar



Pré-requisito: JDK \[versão que você usa, ex.: 17] ou superior.



```bash

git clone https://github.com/Cauasaturnino/Mobilidade\_Urbana\_Java.git

cd Mobilidade\_Urbana\_Java

javac -d out src/br/com/mobilidade/\*.java src/br/com/mobilidade/modelo/\*.java src/br/com/mobilidade/servico/\*.java

java -cp out br.com.mobilidade.Main

```



\## Autor



Cauã Saturnino, \[https://www.linkedin.com/in/cauasaturnino/]

