Try:
entrada = int(input("Ingrese la cantidad de equipos: "))
n=0
mayor=0
for i in range(1, entrada+1):
    equipo = input(f"Ingrese el equipo{i}")
    numero = int (input(f"Ingrese el numero de puntos {i}: "))
    if numero > n:
        n = numero
        e = equipo
print (f"El ganador es {e} con {n} puntos")
Except valueError:
    Print ("ingreso un dato invalido")