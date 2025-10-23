# atividade lista encadeada simples!

class Node():
    
    def __init__(self, nome):
        self.name=nome
        self.next = None
        
    def getNome(self):
        return  self.name
    
    
    def setData(self, novNome):
         self.name = novNome
        
    def __eq__(self, other):
        return ( self.name) == ( other.name)
    
    
    
    # para comparar dois objetos, preciso fazer um método __eq__ na classe do objeto especifico que quero comparar para substituir o 
    # == nos outros metodos