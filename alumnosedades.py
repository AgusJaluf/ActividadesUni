alumnos=[0]*10
promedio=0
cont=0
for i in range(len(alumnos)):
    alumnos[i]=int(input(""))
    promedio=promedio+alumnos[i]
promedio=promedio/10
print("Promedio General:",promedio)

for i in range(len(alumnos)):
    if alumnos[i]>promedio:
        cont=cont+1
print("Cantidad de Edades mayores al promedio:",cont)