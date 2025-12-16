#PROGRAMACION 1
#COMISION ING. DEMICHERI
#GRUPO NRO 5

#ESTE ES UN ISBN PARA PRUEBA 9684443242
while True:   
    try:
        numero = int(input("Ingrese el ISBN: "))
        # evaluamos si el numero al menos tiene 10 cifras
        if 1000000000 <= numero <= 9999999999:
            unid10 = numero // 1000000000
            unid9 = (numero % 1000000000) // 100000000
            unid8 = (numero % 100000000) // 10000000
            unid7 = (numero % 10000000) // 1000000
            unid6 = (numero % 1000000) // 100000
            unid5 = (numero % 100000) // 10000
            unid4 = (numero % 10000) // 1000
            unid3 = (numero % 1000) // 100
            unid2 = (numero % 100) // 10
            unid1 = numero % 10
            #calculo del digito verificador
            verificador = (1 * unid10 + 2 * unid9 + 3 * unid8 + 4 * unid7 + 5 * unid6 + 6 * unid5 + 7 * unid4 + 8 * unid3 + 9 * unid2) % 11
            #comparamos el digito verificador con el resultado del calcuio
            if unid1 == verificador:
                print("ES un ISBN válido!!!!")
                break
            else:
                print("NO es un ISBN válido")
        else:
            print("No es un ISBN válido, ingrese los 10 dígitos")
    # excepcion al presionar enter
    except ValueError:
        print("El enter solo no es un ISBN, Ingrese un ISBN válido")