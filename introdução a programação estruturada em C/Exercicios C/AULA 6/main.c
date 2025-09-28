#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	// EXEMPLOS DE WHILE
	
	//int contador = 1;
	
	// 1 VERDADE
	// 0 FALSO
	/*
	while(contador <= 10){// enquanto o contador for menor ou igual a 10, faça
		
		printf("%i\n", contador);
		contador++; // INCREMENTA(SOMA) O VALOR DO CONTADOR POR ELE MESMO MAIS 1 
	}
	
	
	int numero = 1;
	int soma = 0;
	
	while(numero <= 1000){		
		soma += numero; // ADICIONAR O NUMERO ATUAL A SOMA 
		numero++;       // INCREMENTAR O VALOR DE NUMERO A CADA INTERAÇÃO
		
	}// FIM DO WHILE
	
	printf("a soma dos numeros de 1 a 1000 e: %i\n", soma);
	
	
	int a, b, c, d, e = 10;
	
	int a = 10;
	int b = 10;
	int c = 10;
	int d = 10;
	int e = 10;
	*/
	//int numero = 2;
	//int i = 2;
	
	/*
	int numero, i = 2;
	
	int primo = 1; // numero primo
	
	printf("digite um numero inteiro positivo: ");
	
	scanf("%d", &numero);
	
	while(i <= numero / 2){
		
		if(numero % i == 0){
			primo = 0; // SE FOR DIVISIVEL POR 2, O NUMERO NÃO É PRIMO
			break;
		}// FIM DO IF
		
		i++;
		
	}//FIM DO WHILE
	
	if(primo == 1 && numero > 1){
		printf("o numero %i eh primo!\n", numero);
	}else{
		printf("o numero %i não eh primo!\n", numero);
	}
	*/
	
	int numero, fatorial = 1;
	int contador = 1;
	
	printf("digite um numero inteiro positivo: ");
	scanf("%i", &numero);
	
	if(numero < 0){
		printf("numero negativo não se aplica a fatorial\n");
		
		return 1;  // retorna ERRO pois foi digitado um numero negativo
	}//FIM DO IF
	
	while(contador <= numero){
		
		fatorial *= contador; // MULTIPLICA O FATORIAL PELO CONTADOR
		contador++; // INCRIMENTA O CONTADOR
		
	}//FIM DO WHILE
	
	printf("o fatorial de %i eh: %i\n", numero, fatorial);
	
	

	
	//EXEMPLO DO-WHILE
	
	/*
	
	&& é equivalente a "e"
	|| é equivalente a "ou"
	
	exemplo: um login e senha
	
	if(login == "aluno" && senha == 123)
	
	
	
	
	*//*
	
	do{
		printf("digite um numero entre 1 e 10: ");
		scanf("%i", &numero);
		
		if(numero < 1 || numero > 10){ //SE O NUMERO FOR MENOR QUE 1 OU O NUMERO FOR MAIOR QUE 10 
			printf("numero inválido! por favor, digite um numero entre 1 e 10!\n");
		}
	}while(numero < 1 || numero > 10);	
		printf("voce digitou: %i\n", numero);
	
	*/
	
	return 0;
}