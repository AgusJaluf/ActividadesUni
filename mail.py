mail=input()
longitudMail=len(mail)
contadorArroba=0
contadorPunto=0
for i in range(0,longitudMail,1):
    if mail[i]=="@":
        contadorArroba=contadorArroba+1
        posicionArroba=i
    if mail[i]==".":
        contadorPunto=contadorPunto+1
if contadorArroba==1 and contadorPunto>=1 and posicionArroba!=0:
    print("mail válido")
else:
    print("mail inválido")