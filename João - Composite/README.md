# Composite

## Propósito

O Composite é um padrão de projeto estrutural que permite que você componha objetos em estruturas de árvores e então trabalhe com essas estruturas como se elas fossem objetos individuais.

## Problema

O uso do padrão Composite faz sentido apenas quando o modelo central de sua aplicação pode ser representada como uma árvore.

Um exemplo: Tem-se dois tipos de objetos: Produtos e Caixas. Uma Caixa pode conter diversos Produtos bem como um número de Caixas menores. Essas Caixas menores também podem ter alguns Produtos ou até mesmo Caixas menores que elas, e assim em diante.

Digamos que você decida criar um sistema de pedidos que usa essas classes. Os pedidos podem conter produtos simples sem qualquer compartimento, bem como caixas recheadas com produtos... e outras caixas. Como você faria para determinar o preço total desse pedido?

![picture1](https://refactoring.guru/images/patterns/diagrams/composite/problem-pt-br.png?id=76ac3c711bfdff9dcaebc2f31e3b4359)

Existe uma solução direta para isso: desempacotar todas as caixas, verificar cada produto e então calcular o total. Isso pode ser viável no mundo real; mas em um programa, não é tão simples como executar uma iteração. Você tem que conhecer as classes dos Produtos e Caixas que você está examinando, o nível de aninhamento das caixas e outros detalhes cabeludos de antemão. Tudo isso torna uma solução direta muito confusa ou até impossível.

## Solução

O padrão Composite sugere que você trabalhe com Produtos e Caixas através de uma interface comum que declara um método para a contagem do preço total.

A forma de funcionamento funcionamento desse método, para um produto, ele simplesmente retornaria o preço dele. Para uma caixa, ele teria que ver cada item que ela contém, perguntar seu preço e então retornar o total para essa caixa. Se um desses itens for uma caixa menor, aquela caixa também deve verificar seu conteúdo e assim em diante, até que o preço de todos os componentes internos sejam calculados. Uma caixa pode até adicionar um custo extra para o preço final, como um preço de embalagem.

O maior benefício dessa abordagem é que não é necessário se preocupar sobre as classes concretas dos objetos que compõem essa árvore. Não há necessidade de saber se um objeto é um produto simples ou uma caixa sofisticada. É possível tratar todos eles com a mesma interface e quando os métodos são chamados, os próprios objetos passam o pedido pela árvore.

## Analogia com o mundo real

![picture2](https://refactoring.guru/images/patterns/diagrams/composite/live-example.png?id=548a7cec45b493af66e8bfe524a137d3)

Exércitos são estruturados como hierarquias. Um exército consiste de diversas divisões; uma divisão é um conjunto de brigadas, e uma brigada consiste de pelotões, que podem ser divididos em esquadrões. Finalmente, um esquadrão é um pequeno grupo de soldados reais. Ordens são dadas do topo da hierarquia e são passadas abaixo para cada nível até cada soldado saber o que precisa ser feito.

## Estrutura do Composite

![picture3](https://refactoring.guru/images/patterns/diagrams/composite/structure-pt-br.png?id=d8a3392bb00602989fb6c4d7ae404f95)

* A interface Componente descreve operações que são comuns tanto para elementos simples como para elementos complexos da árvore.
* A Folha é um elemento básico de uma árvore que não tem sub-elementos. Geralmente, componentes folha acabam fazendo boa parte do verdadeiro trabalho, uma vez que não tem mais ninguém para delegá-lo.
* O Contêiner (ou composite) é o elemento que tem sub-elementos: folhas ou outros contêineres. Um contêiner não sabe a classe concreta de seus filhos. Ele trabalha com todos os sub-elementos apenas através da interface componente. Ao receber um pedido, um contêiner delega o trabalho para seus sub-elementos, processa os resultados intermediários, e então retorna o resultado final para o cliente.
* O Cliente trabalha com todos os elementos através da interface componente. Como resultado, o cliente pode trabalhar da mesma forma tanto com elementos simples como elementos complexos da árvore.

## Aplicabilidade

É utilizado o padrão Composite quando se tem que implementar uma estrutura de objetos tipo árvore.

O padrão Composite fornece dois tipos básicos de elementos que compartilham uma interface comum: folhas simples e contêineres complexos. Um contêiner pode ser composto tanto de folhas como por outros contêineres. Isso permite a você construir uma estrutura de objetos recursiva aninhada que se assemelha a uma árvore.

É utilizado o padrão quando há necessidade tratar tanto os objetos simples como os compostos de forma uniforme.

Todos os elementos definidos pelo padrão Composite compartilham uma interface comum. Ou seja, não há preocupação com a classe concreta dos objetos com os quais está trabalhando.

## Como implementar 

1. Certifique-se que o modelo central de sua aplicação possa ser representada como uma estrutura de árvore. Tente quebrá-lo em elementos simples e contêineres. Lembre-se que contêineres devem ser capazes de conter tanto elementos simples como outros contêineres.
2. Declare a interface componente com uma lista de métodos que façam sentido para componentes complexos e simples.
3. Crie uma classe folha que represente elementos simples. Um programa pode ter múltiplas classes folha diferentes.
4. Crie uma classe contêiner para representar elementos complexos. Nessa classe crie um vetor para armazenar referências aos sub-elementos. O vetor deve ser capaz de armazenar tanto folhas como contêineres, então certifique-se que ele foi declarado com um tipo de interface componente. Quando implementar os métodos para a interface componente, lembre-se que um contêiner deve ser capaz de delegar a maior parte do trabalho para os sub-elementos.
5. Por fim, defina os métodos para adicionar e remover os elementos filhos no contêiner.