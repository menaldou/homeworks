def cedula(texto):
    nocero=texto.strip("0")
    cedula=int(nocero,0)
    verificador=cedula%10
    n=cedula//10
    s=0
    while (n>0):
        impar=n%10
        n=n//10
        impar=2*impar
        if (impar>9):
            impar=impar-9
        par=n%10
        n=n//10
        s=s+impar+par
    ds=s//10+1
    s=ds*10-s
    if (s>=10):
        s=s-10
    if (s==verificador):
        z=1
    else:
        z=0
    return z