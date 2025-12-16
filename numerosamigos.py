def suma_divisores_propios(n):
    suma = 0
    for i in range(1, n):
        if n % i == 0:
            print(f"el {n} se puede dividir por {i}")
            suma += i
    print(f"esto da un total de {suma}")
    return suma

def son_amigos(a, b):
    return suma_divisores_propios(a) == b and suma_divisores_propios(b) == a

# Ejemplo de uso
numero1 = 220
numero2 = 284

if son_amigos(numero1, numero2):
    print(f"{numero1} y {numero2} son números amigos.")
else:
    print(f"{numero1} y {numero2} no son números amigos.")