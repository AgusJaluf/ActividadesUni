cantidad=0
registro=0
mayor_valor=0
ciudad=""
ciudad_mayor=""
variacion=0
limite=float(0.5)
#salida=str("exit")
while ciudad.lower() !="exit":
    try:
        ciudad=input("ingrese la ciudad:")
        if ciudad.lower()=="exit":
            if cantidad==0:
                print("no se registro ningun valor, algo anda mal")
                break 
            if registro>2:
                print("Alerta! Movimiento detectado por información cruzada")
                print(f"Hay {cantidad} sismografos que detectan movimiento")
                print(f"El mayor movimiento detectado es en {ciudad_mayor} con un valor de {mayor_valor}")
                print(f"Mayor muestreo compuesto por {cantidad} muestras")
                break
            else:
                print(f"no hay mas de 2 movimientos detectados mayores a 0.5 en la muestra de {cantidad} sismografos")
                break

        variacion=float(input("ingrese la variacion:"))
        cantidad += 1
        if variacion<0:
            print("no es una medicion valida")
        
        elif variacion>=limite:
            registro += 1
            mayor_valor=variacion
            ciudad_mayor=ciudad 
                    
    except ValueError:
        print("el enter no es valido")