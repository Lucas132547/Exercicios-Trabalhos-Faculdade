#include <stdio.h>
#include <stdlib.h>

#define MAX_PRODUTOS 5
#define MAX_NOME 20
#define MAX_DATA 20

typedef struct {
    char nome[MAX_NOME];
    int quantidade;
    float preco;
} Produtos;

int main(int argc, char *argv[]) {

    Produtos produtos[MAX_PRODUTOS];
    int numProdutos = 0;
    int opcao;
    char nome[MAX_NOME];
    char data[MAX_DATA];
    float precoTotal = 0;

    do {
        printf("1. Cadastro de pedido\n2. Sair\n");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1: {
                printf("Insira seu nome: ");
                scanf("%s", nome);

                printf("Insira a data do pedido (dd/mm/aaaa): ");
                scanf("%s", data);

                printf("Quantos produtos deseja cadastrar? (max %d): ", MAX_PRODUTOS);
                int numEntrar;
                scanf("%d", &numEntrar);

                if (numEntrar > MAX_PRODUTOS) {
                    printf("Apenas %d produtos podem ser cadastrados de uma vez.\n", MAX_PRODUTOS);
                    break;
                }

                for (int i = 0; i < numEntrar; i++) {
                    printf("Produto %d:\n", i + 1);
                    printf("Nome do produto: ");
                    scanf("%s", produtos[i].nome);

                    printf("Quantidade: ");
                    scanf("%d", &produtos[i].quantidade);

                    printf("Preco do produto: ");
                    scanf("%f", &produtos[i].preco);

                    printf("Produto cadastrado\n");
                    
                    
                    
                    precoTotal += produtos[i].quantidade * produtos[i].preco;
                }

                printf("--------------Detalhes do pedido:--------------\n");
                printf("Nome: %s\nData: %s\n", nome, data);

                for (int i = 0; i < numEntrar; i++) {
                    printf("Produto %d:\n", i + 1);
                    printf("Nome: %s\nQuantidade: %d\nPreco: %.2f\n", produtos[i].nome, produtos[i].quantidade, produtos[i].preco);
                }
                printf("Preco total do pedido:%.2f\n", precoTotal);
                break;
            }
            case 2: 
                printf("Finalizando o programa\n");
                break;
            default:
                printf("Opcao invalida. Tente novamente.\n");
        }
    } while (opcao != 2);

    return 0;
}
