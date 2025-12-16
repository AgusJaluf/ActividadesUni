cantidad=int(input("ingrese cantidad"))
porcentaje=int(input("ingrese porcentaje"))
contador=0

while contador<=cantidad:
    contador+=1
    precio_viejo=float(input("ingrese precio:"))
    precio_nuevo=precio_viejo+(precio_viejo*(porcentaje/100))
    #print(precio_nuevo)
    digito=int(precio_nuevo)%100
    #print(digito)
    if digito <= 50:
        precio_modificado=precio_nuevo-digito+49
    else:
        precio_modificado=precio_nuevo-digito+99
    print(f"el nuevo precio es {int(precio_modificado)}")