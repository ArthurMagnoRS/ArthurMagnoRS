import Ordenar

print("\033[1mBem vindo ao Menu de Ordenações!\nAqui você poderá selecionar dentre 7 opções de ordenações diferentes, para 5 arquivos diferentes!\033[0m")
print("//////////////////////////////////////////////////////////////////////////////////////////////")
while True:
    
    
    print("Pressione 1 para ir ao Menu Quick;\nPressione 2 para ir ao Menu Bubble;\nPressione 3 para ir ao Menu Selection")
    print("Pressione 4 para ir ao Menu Insertion;\nPressione 5 para ir ao Menu Shell;\nPressione 6 para ir ao Menu Heap;")
    print("Pressione 7 para ir ao Menu Merge;\nPressione 0 para sair do programa.")
    print("//////////////////////////////////////////////////////////////////////////////////////////////")
    R = int(input())
    while R>7 or R<0:
        R = int(input("Digite a opção novamente.\n"))
    match R:
        case 1:
            while True:
                print("\033[1mDeseja fazer o método QuickSort com qual número de palavras?\033[0m")
                print("1: 50k;\n2: 100k;\n3: 250k;\n4: 500k;\n5: 1000k;\nou 0 para voltar ao Menu de Ordenações.")
                R2 = int(input())
                while R2>5 or R2<0:
                    R2 = int(input("Digite a opção novamente.\n"))
                match R2:
                    case 1:
                        Ordenar.quickSort("nomes50k.txt")
                    case 2:
                        Ordenar.quickSort("nomes100k.txt")
                    case 3:
                        Ordenar.quickSort("nomes250k.txt")
                    case 4:
                        Ordenar.quickSort("nomes500k.txt")
                    case 5:
                        Ordenar.quickSort("nomes1000k.txt")
                    case 0:
                        print("//////////////////////////////////////////////////////////////////////////////////////////////")
                        break
        case 2:
            while True:
                print("\033[1mDeseja fazer o método BubbleSort com qual número de palavras?\033[0m")
                print("1: 50k;\n2: 100k;\n3: 250k;\n4: 500k;\n5: 1000k;\nou 0 para voltar ao Menu de Ordenações.")
                R2 = int(input())
                match R2:
                    case 1:
                        Ordenar.bubbleSort("nomes50k.txt")
                    case 2:
                        Ordenar.bubbleSort("nomes100k.txt")
                    case 3:
                        Ordenar.bubbleSort("nomes250k.txt")
                    case 4:
                        Ordenar.bubbleSort("nomes500k.txt")
                    case 5:
                       Ordenar.bubbleSort("nomes1000k.txt")
                    case 0:
                        print("//////////////////////////////////////////////////////////////////////////////////////////////")
                        break
        case 3:
            while True:
                print("\033[1mDeseja fazer o método SelectionSort com qual número de palavras?\033[0m")
                print("1: 50k;\n2: 100k;\n3: 250k;\n4: 500k;\n5: 1000k;\nou 0 para voltar ao Menu de Ordenações.")
                R2 = int(input())
                match R2:
                    case 1:
                        Ordenar.selectionSort("nomes50k.txt")
                    case 2:
                        Ordenar.selectionSort("nomes100k.txt")
                    case 3:
                        Ordenar.selectionSort("nomes250k.txt")
                    case 4:
                        Ordenar.selectionSort("nomes500k.txt")
                    case 5:
                        Ordenar.selectionSort("nomes1000k.txt")
                    case 0:
                        print("//////////////////////////////////////////////////////////////////////////////////////////////")
                        break
        case 4:
            while True:
                print("\033[1mDeseja fazer o método InsertionSort com qual número de palavras?\033[0m")
                print("1: 50k;\n2: 100k;\n3: 250k;\n4: 500k;\n5: 1000k;\nou 0 para voltar ao Menu de Ordenações.")
                R2 = int(input())
                match R2:
                    case 1:
                        Ordenar.insertionSort("nomes50k.txt")
                    case 2:
                        Ordenar.insertionSort("nomes100k.txt")
                    case 3:
                        Ordenar.insertionSort("nomes250k.txt")
                    case 4:
                        Ordenar.insertionSort("nomes500k.txt")
                    case 5:
                        Ordenar.insertionSort("nomes1000k.txt")
                    case 0:
                        print("//////////////////////////////////////////////////////////////////////////////////////////////")
                        break
        case 5:
            while True:
                print("\033[1mDeseja fazer o método ShellSort com qual número de palavras?\033[0m")
                print("1: 50k;\n2: 100k;\n3: 250k;\n4: 500k;\n5: 1000k;\nou 0 para voltar ao Menu de Ordenações.")
                R2 = int(input())
                match R2:
                    case 1:
                       Ordenar.shellSort("nomes50k.txt")
                    case 2:
                        Ordenar.shellSort("nomes100k.txt")
                    case 3:
                        Ordenar.shellSort("nomes250k.txt")
                    case 4:
                        Ordenar.shellSort("nomes500k.txt")
                    case 5:
                        Ordenar.shellSort("nomes1000k.txt")
                    case 0:
                        print("//////////////////////////////////////////////////////////////////////////////////////////////")
                        break
        case 6:
            while True:
                print("\033[1mDeseja fazer o método HeapSort com qual número de palavras?\033[0m")
                print("1: 50k;\n2: 100k;\n3: 250k;\n4: 500k;\n5: 1000k;\nou 0 para voltar ao Menu de Ordenações.")
                R2 = int(input())
                match R2:
                    case 1:
                        Ordenar.heapSort("nomes50k.txt")
                    case 2:
                        Ordenar.heapSort("nomes100k.txt")
                    case 3:
                        Ordenar.heapSort("nomes250k.txt")
                    case 4:
                        Ordenar.heapSort("nomes500k.txt")
                    case 5:
                        Ordenar.heapSort("nomes1000k.txt")
                    case 0:
                        print("//////////////////////////////////////////////////////////////////////////////////////////////")
                        break
        case 7:
            while True:
                print("\033[1mDeseja fazer o método MergeSort com qual número de palavras?\033[0m")
                print("1: 50k;\n2: 100k;\n3: 250k;\n4: 500k;\n5: 1000k;\nou 0 para voltar ao Menu de Ordenações.")
                R2 = int(input())
                match R2:
                    case 1:
                        Ordenar.mergeSort("nomes50k.txt")
                    case 2:
                        Ordenar.mergeSort("nomes100k.txt")
                    case 3:
                        Ordenar.mergeSort("nomes250k.txt")
                    case 4:
                        Ordenar.mergeSort("nomes500k.txt")
                    case 5:
                        Ordenar.mergeSort("nomes1000k.txt")
                    case 0:
                        print("//////////////////////////////////////////////////////////////////////////////////////////////")
                        break
        case 0:
            print("Boa Noite!")
            break
            
            
                                    
                        
                        
