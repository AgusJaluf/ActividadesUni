PlantaBaja= 20
Subnivel1= 40
Piso1= 50
Subnivel2= 50
CapacidadTotal= 160
Autos= 0
boton= int(input())
while boton== 1:
    Autos= Autos+1 
    CapacidadTotal = CapacidadTotal-1
    if Autos <= 20:
        print ("Estacionar en Planta Baja")
        PlantaBaja= PlantaBaja-1
    elif Autos > 20 and Autos <= 60:
        print ("Estacionar en Subnivel 1")
        Subnivel1= Subnivel1-1
    elif Autos > 60 and Autos <= 110:
        print ("Estacionar en Piso 1")
        Piso1=Piso1-1
    elif Autos > 110 and Autos <= 160:
        print ("Estacionar en Subnivel 2")
        Subnivel2= Subnivel2-1
    boton= int(input())
    if boton==0:
        print ("Subnivel 2: ", Subnivel2, "/50")
        print ("Subnivel 1: ", Subnivel1, " /40")
        print ("Planta Baja: ", PlantaBaja, " /20")
        print ("Piso 1: ", Piso1, " /50")
        print ("Capacidad total: ", CapacidadTotal, " /160")