from node import Node
class Lista:
    def __init__(self):
        self.head = None
        
    def isEmpty(self):
        return self.head is None
    
    def addObj(self, obj):
        # primeiro caso a lista esteja vazia:
        new = Node(obj)
        if self.isEmpty() is True:
            new.next = self.head
            new.ant = self.head
            self.head = new
        else:
        
            i = self.head
            while i:
                
                # agora, caso o getInt() do obj seja maior que o self.head e/ou maior que os outros da direita
                if new.getInt()>i.getInt():
                    if i.next == None:
                        new.next = i.next
                        new.ant = i
                        i.next = new
                        break
                    elif new.getInt() <= i.next.getInt():
                        new.next = i.next
                        i.next.ant = new
                        new.ant = i
                        break
                    elif new.getInt() > i.next.getInt():
                        new.next = i.next.next
                        new.ant = i.next
                        i.next.next = new
                        break
                    i = i.next
                # agora, caso o getInt() do obj seja menor que o self.head e/ou menor que os outros da esquerda
                elif new.getInt()<i.getInt():
                    if i.ant == None:
                        new.ant = i.ant
                        new.next = i
                        i.ant = new
                        break
                        
                    elif new.getInt() >= i.ant.getInt():
                        new.ant = i.ant
                        i.ant.next = new
                        new.next = i
                        break
                    elif new.getInt() < i.ant.getInt():
                        new.ant = i.ant.ant
                        new.next = i.ant
                        i.ant.ant = new
                        break
                    i = i.ant
                
             
                    
    def procuraObj(self, obj):
        procurado = Node(obj)
        i = self.head
        if self.isEmpty() is True:
            return print("A lista está vazia.")
        else:
            if procurado.getInt()==i.getInt():
                    print("O objeto está na lista.")
            else:       
               
                while i:
                    
                    if procurado.getInt()==i.getInt():
                        return print("O objeto está na lista.")

                    if procurado.getInt()>i.getInt():
                            if i.next is not None:
                                if procurado.getInt() == i.next.getInt():
                                    print("O objeto está na lista.")
                                    return
                            
                                i = i.next
                            else: 
                                return print("O objeto não está na lista.")
                        
                            
                    elif procurado.getInt()<i.getInt():
                       
                            if i.ant is not None:
                                if procurado.getInt() == i.ant.getInt():
                                    print("O objeto está na lista.")
                                    return
                                i = i.ant
                            else:
                                return print("O objeto não está na lista.") 
                                
                    return print("O objeto não está na lista.") 
                        
                        
                            
                
                
        
            
            
    
    
            