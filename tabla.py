tabla=[[0 for f in range(10)] for c in range(10)]
for f in range(10):
    for c in range(10):
        tabla[c][f]=(f+1)*(c+1)
        print
for fila in range(10):
    for columna in range(10):
        print(tabla[fila][columna],end=" ")
    print()