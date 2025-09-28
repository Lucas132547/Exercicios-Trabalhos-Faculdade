#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	
	/*
	char   1 byte
	int    2 byte
	float  4 byte
	double 8 byte
	void   vazio
	
	integer %i ou %d
	float ou double  %f
	char %c
	string %s
	*/
	
	/*
	int num = 10;
	printf("%i\n", num);
	
	float nota = 7.5;
	printf("%f\n", nota);
	
	printf("%i - %f", num, nota);	
	*/
	
	/*	
	int num1, num2;
	num1 = 10;
	num2 = 2;
	
	int soma = num1 + num2;
	printf("o resultado da soma é: %i\n", soma);	
	
	int subtracao = num1 - num2;
	printf("o resultado da subtracao e: %i\n", subtracao);
	
	int multiplicao = num1 * num2;
	printf("o resultado da multiplicao e: %i\n", multiplicao);
	
	int divisao = num1 / num2;
	printf("o resultado da divisao e: %i\n", divisao);
	*/
	
	// scanf(TIPO VARIAVEL, VARIAVEL QUE RECEBE);
	
	/*
	int num;
	printf("digite um numero inteiro: \n");
	scanf("%i", &num);	
	printf("o valor do numero interio e: %i\n", num);
	*/
	
	int num1, num2, soma, sub, mult, div;
	
	printf("\n");
	printf("###### calculadora #######\n");
	printf("digite dois numeros inteiros: \n");
	scanf("%i%i", &num1, &num2);
	
	soma = num1 + num2;
	sub  = num1 - num2;
	mult = num1 * num2;
	div  = num1 / num2;
	
	printf("o resultado da soma é: %i\n", soma);
	printf("o resultado da subtracao e: %i\n", sub);
	printf("o resultado da multiplicao e: %i\n", mult);
	printf("o resultado da divisao e: %i\n", div);
	
	return 0; // retorna que o programa foi executado corretamente! 
}






