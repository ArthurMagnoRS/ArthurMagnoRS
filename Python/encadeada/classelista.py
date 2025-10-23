from nodulo import Node
class lista:
    def __init__(self):
        self.head = None
    
    
    def Contem(self, nome):
        obj = self.head
        procurado = Node(nome)
        while obj:
            N1 = obj.getNome()
            N2 = procurado.getNome()
            if N2.lower() == N1.lower():
                return print("O objeto está na lista!")
            obj = obj.next  
        return print("O objeto não está na lista!")
        
        
    
        
    def procuraRepetido(self, nome):
        obj = self.head
        procurado = Node(nome)
        while obj:
            N1 = obj.getNome()
            N2 = procurado.getNome()
            if N2.lower() == N1.lower():
                return 1
            obj = obj.next   
        return 0
                
    
    
    

    def addInicio(self, nome):
        
        novoObj = Node (nome)
        if self.procuraRepetido(nome) == 0:
            novoObj.next = self.head
            self.head = novoObj
            print("Um objeto foi adicionado ao inicio da lista!")
        else: 
            print("O objeto/nome já está na lista.")
            
            
        
    def addFinal(self, nome):
        if self.procuraRepetido(nome) == 1:
            print("O objeto/nome ja está na lista.")
        else:
            obj = self.head
            cont1 = 0
            cont2 = 0
            while obj:
                cont1+=1
                obj = obj.next
                
            
            obj = self.head
            while obj: 
                cont2+=1
                if cont1 == 1:
                    Aux = obj 
                    novoObj = Node (nome)
                    novoObj.next = None 
                    Aux.next = novoObj
                    print("um objeto foi adicionado ao final da lista!")

                    break
                    
                    
                if cont2 == cont1-1:
                    Aux = obj.next
                    novoObj = Node (nome)
                    novoObj.next = None
                    Aux.next = novoObj
                    print("um objeto foi adicionado ao final da lista!")

                    break
                obj = obj.next
            
                
                
      #pau              
               
        
        
    def TotalElementos(self):
        if self.head is None:
            return print("A lista está vazia.")
        cont3 = 0
        obj = self.head
        while obj:
            print(obj.getNome())
            cont3+=1
            obj = obj.next
        print(f"Existe {cont3} objeto(s) na lista!")    
        
        
    def Excluir(self, nome):
        ex = Node(nome)
        # guardar em variaveis o objeto anterior ao objeto que se quer excluir, e o objeto.next deste objeto anterior(que seria o que se quer excluir)
        if self.head == ex:
           OB = self.head
           OB2 = OB.next
           self.head = OB2
           ex = None
           print("Objeto excluído com sucesso!")
           return
           
        
        obj = self.head
        while obj:
            if obj.next == ex:
                OB = obj
                OB2 = obj.next
                OB.next = OB2.next
                ex = None
                print("Objeto excluído com sucesso!")
                return
                
            obj = obj.next 
                
                     
        if obj is False:
            print("O objeto não está na lista!")
                