def fora():
    x = 10

    def dentro():
        print(x)
        
    dentro()

fora()
