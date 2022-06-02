from __future__ import annotations
from abc import ABC, abstractmethod
from typing import List


class Component(ABC):
    """
    Declaração da base que declara as operações comuns para ambos os objetos
    simples e complexos de uma composição    
    """

    @property
    def parent(self) -> Component:
        return self._parent

    @parent.setter
    def parent(self, parent: Component):
        """
        Componente base pode declarar uma interface para configuração e 
        acessando um pai do componente em uma estrutura de árvore. 
        """

        self._parent = parent      

class Leaf(Component):
    """
    A classe Leaf representa os objetos finais de uma composição. Uma folha não pode
    tem filhos.    
    """

    def operation(self) -> str:
        return "Leaf"


class Composite(Component):
    """    
    A classe Composite representa os componentes complexos que podem ter
    filhos. 
    """

    def __init__(self) -> None:
        self._children: List[Component] = []

    
    def add(self, component: Component) -> None:
        self._children.append(component)
        component.parent = self

    def remove(self, component: Component) -> None:
        self._children.remove(component)
        component.parent = None

    def is_composite(self) -> bool:
        return True

    def operation(self) -> str:
        """
        O Composite executa sua lógica primária de uma maneira particular. Isto
        percorre recursivamente por todos os seus filhos, coletando e somando
        seus resultados. 
        """

        results = []
        for child in self._children:
            results.append(child.operation())
        return f"Branch({'+'.join(results)})"
        # Não existe branch sem folhas 

def client_code(component: Component) -> None:
    """
    Esta função funciona com todos os componentes via interface base
    """

    print(f"RESULT: {component.operation()}", end="")


def client_code2(component1: Component, component2: Component) -> None:
    """    
    Graças ao fato das operações de gestão de filhos serem declaradas no
    classe base Component, o código cliente pode trabalhar com qualquer componente, simples ou
    complexos, sem depender de suas classes concretas.
    """

    if component1.is_composite():
        component1.add(component2)

    print(f"RESULT: {component1.operation()}", end="")


if __name__ == "__main__":
    
    simple = Leaf()
    print("Client: Possuo um componente simples:")
    client_code(simple)
    print("\n")
   
    tree = Composite()

    branch1 = Composite()
    branch1.add(Leaf())
    branch1.add(Leaf())

    branch2 = Composite()
    branch2.add(Leaf())

    tree.add(branch1)
    tree.add(branch2)

    print("Client: Agora eu tenho uma árvore composta")
    client_code(tree)
    print("\n")

    print("Nao eh necessario checar as classes componentes mesmo gerenciando a arvore")
    client_code2(tree, simple)