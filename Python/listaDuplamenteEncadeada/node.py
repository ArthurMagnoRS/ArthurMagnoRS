class Node:
    def __init__(self, obj):
        self.int = int(obj)
        self.next = None
        self.ant = None
    
    
    def getInt(self):
        return self.int
    
    def setInt(self, objt):
        self.newint = objt
        
    def __eq__(self, other):
        return self.getInt() == other.getInt()
    
    def __ne__(self, other):
        return self.getInt() != other.getInt()
    
    def __ge__(self, other):
        return self.getInt() >= other.getInt()
    
    def __le__(self, other):
        return self.getInt() <= other.getInt()
    
    def __gt__(self, other):
        return self.getInt() > other.getInt()
    
    def __lt__(self, other):
        return self.getInt() < other.getInt()
    #------------------------------------------------
    def __eq__(self, other):
        return self.ant == other.ant
    def __ne__(self, other):
        return self.next != other.next
    
    def __eq__(self, other):
        return self.next == other.next
    def __ne__(self, other):
        return self.ant != other.ant
    