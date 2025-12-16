matriz=[[0 for j in range(5)] for i in range(6)]
def imprimirPunto(fila,columna):
        matriz[fila][columna]=1
def imprimirCuadrado(fila,columna):
    for i in range(columna):
        matriz[0][i]=1
        matriz[fila-1][i]=1
    for j in range(fila):
        matriz[i][0]=1
        matriz[0][columna-1]=1
def imprimirCruz(fila,columna):
    for i in range(fila):
        matriz[i][i]=1
        matriz[i][columna-1-i]=1
def mostrarMatriz(fila,columna):
    for i in range(fila):
                for j in range(fila):
                    print(matriz[i][j],end=" ")
                print()
def limpiarMatriz():
    for i in range(6):
        for j in range(5):
            matriz[i][j]=0
def mostrarEstrella(fila,columnas,centro):
    for i in range(columnas):
        matriz[centro][i]=1
    for j in range(fila):
        matriz[i][centro]=1
def mostrarRombo(fila,columnas,centro):
    imprimirCruz(fila,columnas)

def
    for i in range(centro,fila):
        for j in range(columnas):
            if 
    

fila=int(input("ingrese las filas"))
columnas=int(input("ingrese las columnas"))
print("1-Punto\n2-cuadrado\n3-cruz\n4-estrella\n0-salir")
opcion=int(input("ingrese una opcion"))
centro=int(fila/2)
while (opcion!=0):
    limpiarMatriz()
    if(opcion==1):
        if(fila%2!=0 and fila==columnas):
            centro=int(fila/2)
            imprimirPunto(1,1)
            mostrarMatriz(fila,columnas)
        else:
            print("no cumple con las condiciones para el punto central")
    if(opcion==2):
        limpiarMatriz()
        imprimirCuadrado(fila,columnas)
        mostrarMatriz(fila,columnas)
    if(opcion==3):
        limpiarMatriz()
        imprimirCruz(fila,columnas)
        mostrarMatriz(fila,columnas)
    if(opcion==4):
        limpiarMatriz()
        mostrarEstrella(fila,columnas,centro)
        mostrarMatriz(fila,columnas)
    if(opcion==5):
        limpiarMatriz()
        mostrarRombo(fila,columnas,centro)
        mostrarMatriz(fila,columnas)
    opcion=int(input("ingrese una opcion"))