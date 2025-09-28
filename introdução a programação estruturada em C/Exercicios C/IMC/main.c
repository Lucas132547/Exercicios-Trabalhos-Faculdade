#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[]) {
	
	float altura,peso,IMC, altura2, pesoIdeal;
	
	printf("##############################IMC Calculator##############################\n");   
    printf("Por favor, informe a sua altura (em metros):\n");
    scanf("%f", &altura);
    
    printf("Por favor, informe o seu peso (em quilogramas):\n");
    scanf("%f", &peso);
    
    altura2 = altura * altura;
    
    IMC = peso / altura2;
    
    if (IMC <= 18.5) printf("Voce esta abaixo do peso, seu IMC e %.2f\n", IMC);
    else if (IMC >= 18.6 && IMC <= 24.9) printf("Voce esta no peso ideal, seu IMC e %.2f (parabens)\n", IMC);
    else if (IMC >= 25 && IMC <= 29.9) printf("Voce esta levemente acima do peso, seu IMC e %.2f\n", IMC);
    else if (IMC >= 30 && IMC <= 34.9) printf("Voce tem obesidade grau 1, seu IMC e %.2f\n", IMC);
    else if (IMC >= 35 && IMC <= 39.9) printf("Voce tem obesidade grau 2, seu IMC e %.2f\n", IMC);
    else printf("Voce tem obesidade grau 3, seu IMC e %.2f\n", IMC);
    
    pesoIdeal = 21.7 * altura2;
    
    printf ("Seu peso ideal e %.2f", pesoIdeal);

    return 0;
}