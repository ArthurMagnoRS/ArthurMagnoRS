import time
import Quick
import Bubble
import Selection
import Insertion
import Shell
import Heap
import Merge


def quickSort(arquivo):
    with open (arquivo, mode = "r", encoding = "utf-8") as Ck:
        R = Ck.readlines()
        size = len(R)
        t1 = time.time()
        Quick.quickSort(R, 0, (size-1))
        t = time.time()
        print(f"O tempo gasto foi de: {t-t1}")
        
    
def bubbleSort(arquivo):
    with open (arquivo, mode = "r", encoding = "utf-8") as Ck:
        R = Ck.readlines()
        t1 = time.time()
        Bubble.bubble_sort(R)
        t = time.time()
        print(f"O tempo gasto foi de: {t-t1}")
        

def selectionSort(arquivo):
    with open (arquivo, mode = "r", encoding = "utf-8") as Ck:
           R = Ck.readlines()
           size = len(R)
           t1 = time.time()
           Selection.selectionSort(R, size)
           t = time.time()
           print(f"O tempo gasto foi de: {t-t1}")
           

def insertionSort(arquivo):
    with open (arquivo, mode = "r", encoding = "utf-8") as Ck:
        R = Ck.readlines()
        t1 = time.time()
        Insertion.insertionSort(R)
        t = time.time()
        print(f"O tempo gasto foi de: {t-t1}")
        return t-t1

def shellSort(arquivo):
     with open (arquivo, mode = "r", encoding = "utf-8") as Ck:
        R = Ck.readlines()
       
        t1 = time.time()
        Shell.shellSort(R)
        t = time.time()
        print(f"O tempo gasto foi de: {t-t1}")
        

def heapSort(arquivo):
    with open (arquivo, mode = "r", encoding = "utf-8") as Ck:
        R = Ck.readlines()
        t1 = time.time()
        Heap.heapSort(R)
        t = time.time()
        print(f"O tempo gasto foi de: {t-t1}")
        

def mergeSort(arquivo):
    with open (arquivo, mode = "r", encoding = "utf-8") as Ck:
        R = Ck.readlines()
        size = len(R)
        t1 = time.time()
        Merge.mergeSort(R, 0, size-1)
        t = time.time()
        print(f"O tempo gasto foi de: {t-t1}")
        
    


    
    
           