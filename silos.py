Silo1= 200
Silo2= 150
Silo3= 250
CapacidadTotal= 600
Kilos= 0
carga= int(input("Carga de camion"))
while carga!= -1:
    if Silo1>0 and carga <=Silo1:
        print ("Depositar en silo 1")
        Silo1= Silo1-carga
    elif carga > Silo1 and Silo2>0 and carga <= Silo2:
        print ("Depositar en silo2")
        Silo2= Silo2-carga
    elif Silo3>0 and carga>Silo2 and carga>Silo1 and carga<= Silo3:
        print ("Depositar en silo3")
        Silo3=Silo3-carga
    Kilos= Kilos+carga
    carga= int(input("Carga de camion"))
    if carga==-1 or carga>CapacidadTotal:
        CapacidadTotal = CapacidadTotal-(Silo1+Silo2+Silo3)
        print ("Silo1: ", Silo1, "/200")
        print ("Silo2: ", Silo2, " /150")
        print ("Silo3: ", Silo3, " /250")
        print ("Capacidad total: ", CapacidadTotal, " /600")