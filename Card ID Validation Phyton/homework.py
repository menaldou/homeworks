def verificarci(nro):
    l = len(nro)
    if l == 10 or l == 13: # verificar la longitud correcta
        cad = int(nro[0:2])
        if cad >= 1 and cad <= 24: # verificar codigo de provincia
            tercerdigito = int(nro[2])
            if tercerdigito >= 0 and tercerdigito < 6 : # numeros enter 0 y 6
                if l == 10:
                    return __validarci(nro,0)                       
                elif l == 13:
                    return __validarci(nro,0) and nro[10:13] != '000' # se verifica q los ultimos numeros no sean 000
            elif tercerdigito == 6:
                return __validarci(nro,1) # sociedades publicas
            elif tercerdigito == 9: # si es ruc
                return __validarci(nro,2) # sociedades privadas
            else:
                raise Exception(u'Tercer digito invalido') 
        else:
            raise Exception(u'Codigo de provincia incorrecto') 
    else:
        raise Exception(u'Longitud incorrecta')

def __validarci(nro,tipo):
    total = 0
    if tipo == 0: # cedula y r.u.c persona natural
        base = 10
        d_ver = int(nro[9])# digito verificador
        multip = (2, 1, 2, 1, 2, 1, 2, 1, 2)
    elif tipo == 1: # r.u.c. publicos
        base = 11
        d_ver = int(nro[8])
        multip = (3, 2, 7, 6, 5, 4, 3, 2 )
    elif tipo == 2: # r.u.c. juridicos y extranjeros sin cedula
        base = 11
        d_ver = int(nro[9])
        multip = (4, 3, 2, 7, 6, 5, 4, 3, 2)
    for i in range(0,len(multip)):
        p = int(nro[i]) * multip[i]
        if tipo == 0:
            total+=p if p < 10 else int(str(p)[0])+int(str(p)[1])
        else:
            total+=p
    mod = total % base
    val = base - mod if mod != 0 else 0

    if val==d_ver:
    	print("Cedula correcta")
    else:
    	print("Cedula incorrecta")

    return val == d_ver
verificarci(input("Ingrese numero de cedula: "))