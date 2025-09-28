import os
from pathlib import Path
import sqlite3
import csv
from datetime import datetime
import shutil


class Livraria:
    def __init__(self):
        # Definindo os diretórios principais
        self.BASE_DIR = Path(__file__).resolve().parent
        self.DATA_DIR = self.BASE_DIR / 'data'
        self.BACKUP_DIR = self.BASE_DIR / 'backups'
        self.EXPORT_DIR = self.BASE_DIR / 'exports'

        # Criando diretórios se não existirem
        self.DATA_DIR.mkdir(parents=True, exist_ok=True)
        self.BACKUP_DIR.mkdir(parents=True, exist_ok=True)
        self.EXPORT_DIR.mkdir(parents=True, exist_ok=True)

        # Caminho para o banco de dados
        self.DB_PATH = self.DATA_DIR / 'livraria.db'

        # Inicializando o banco de dados
        self.criar_banco()

    def criar_banco(self):
        """Cria a tabela de livros no banco de dados, caso ainda não exista."""
        conn = sqlite3.connect(self.DB_PATH)
        cursor = conn.cursor()
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS livros (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT NOT NULL,
                autor TEXT NOT NULL,
                ano_publicacao INTEGER,
                preco REAL
            )
        ''')
        conn.commit()
        conn.close()

    def adicionar_livro(self, titulo, autor, ano_publicacao, preco):
        """Adiciona um novo livro ao banco de dados."""
        self.backup_banco()
        conn = sqlite3.connect(self.DB_PATH)
        cursor = conn.cursor()
        cursor.execute('INSERT INTO livros (titulo, autor, ano_publicacao, preco) VALUES (?, ?, ?, ?)',
                       (titulo, autor, ano_publicacao, preco))
        conn.commit()
        conn.close()

    def exibir_livros(self):
        """Exibe todos os livros cadastrados."""
        conn = sqlite3.connect(self.DB_PATH)
        cursor = conn.cursor()
        cursor.execute('SELECT * FROM livros')
        livros = cursor.fetchall()
        conn.close()

        if livros:
            for livro in livros:
                print(f"ID: {livro[0]}, Título: {livro[1]}, Autor: {livro[2]}, Ano: {livro[3]}, Preço: {livro[4]}")
        else:
            print("Nenhum livro cadastrado.")

    def atualizar_preco(self, id_livro, novo_preco):
        """Atualiza o preço de um livro existente."""
        self.backup_banco()
        conn = sqlite3.connect(self.DB_PATH)
        cursor = conn.cursor()
        cursor.execute('UPDATE livros SET preco = ? WHERE id = ?', (novo_preco, id_livro))
        conn.commit()
        conn.close()

    def remover_livro(self, id_livro):
        """Remove um livro do banco de dados."""
        self.backup_banco()
        conn = sqlite3.connect(self.DB_PATH)
        cursor = conn.cursor()
        cursor.execute('DELETE FROM livros WHERE id = ?', (id_livro,))
        conn.commit()
        conn.close()

    def buscar_por_autor(self, autor):
        """Busca livros cadastrados por autor."""
        conn = sqlite3.connect(self.DB_PATH)
        cursor = conn.cursor()
        cursor.execute('SELECT * FROM livros WHERE autor LIKE ?', ('%' + autor + '%',))
        livros = cursor.fetchall()
        conn.close()

        if livros:
            for livro in livros:
                print(f"ID: {livro[0]}, Título: {livro[1]}, Autor: {livro[2]}, Ano: {livro[3]}, Preço: {livro[4]}")
        else:
            print("Nenhum livro encontrado para o autor fornecido.")

    def backup_banco(self):
        backup_file = self.BACKUP_DIR / f"backup_livraria_{datetime.now().strftime('%Y-%m-%d_%H-%M-%S')}.db"
        shutil.copy(self.DB_PATH, backup_file)
        print(f"Backup realizado: {backup_file}")
        self.limpar_backups_antigos()

    def limpar_backups_antigos(self):
        backups = sorted(self.BACKUP_DIR.glob('*.db'), key=os.path.getmtime, reverse=True)
        if len(backups) > 5:
            for backup in backups[5:]:
                os.remove(backup)
                print(f"Backup removido: {backup}")

    def exportar_para_csv(self):
        """Exporta os dados dos livros para um arquivo CSV."""
        # Verifica e cria o diretório de exportação se não existir
        self.EXPORT_DIR.mkdir(parents=True, exist_ok=True)

        conn = sqlite3.connect(self.DB_PATH)
        cursor = conn.cursor()
        cursor.execute('SELECT * FROM livros')
        livros = cursor.fetchall()
        conn.close()

        # Caminho para o arquivo CSV
        export_file = self.EXPORT_DIR / 'livros_exportados.csv'

        try:
            # Criação do arquivo CSV
            with open(export_file, mode='w', newline='') as file:
                writer = csv.writer(file)
                writer.writerow(['ID', 'Título', 'Autor', 'Ano de Publicação', 'Preço'])  # Cabeçalho
                writer.writerows(livros)  # Dados dos livros

            print(f"Dados exportados para {export_file}")
        except PermissionError:
            print(f"Permissão negada para escrever no arquivo: {export_file}")
        except Exception as e:
            print(f"Ocorreu um erro ao exportar: {e}")

    def importar_de_csv(self, file_path):
        """Importa dados de um arquivo CSV e os insere no banco de dados."""
        self.backup_banco()
        try:
            with open(file_path, newline='') as file:
                reader = csv.DictReader(file)
                conn = sqlite3.connect(self.DB_PATH)
                cursor = conn.cursor()

                for row in reader:
                    cursor.execute('INSERT INTO livros (titulo, autor, ano_publicacao, preco) VALUES (?, ?, ?, ?)',
                                   (row['Título'], row['Autor'], row['Ano de Publicação'], row['Preço']))

                conn.commit()
                conn.close()

            print(f"Dados importados de {file_path}")
        except FileNotFoundError:
            print(f"Arquivo não encontrado: {file_path}")
        except Exception as e:
            print(f"Ocorreu um erro ao importar: {e}")

    def menu(self):
        """Exibe o menu de operações e captura as opções do usuário."""
        while True:
            print("\nMenu:")
            print("1. Adicionar novo livro")
            print("2. Exibir todos os livros")
            print("3. Atualizar preço de um livro")
            print("4. Remover um livro")
            print("5. Buscar livros por autor")
            print("6. Exportar dados para CSV")
            print("7. Importar dados de CSV")
            print("8. Fazer backup do banco de dados")
            print("9. Sair")

            escolha = input("Escolha uma opção: ")

            if escolha == '1':
                titulo = input("Título: ")
                autor = input("Autor: ")
                ano_publicacao = int(input("Ano de Publicação: "))
                preco = float(input("Preço: "))
                self.adicionar_livro(titulo, autor, ano_publicacao, preco)
            elif escolha == '2':
                self.exibir_livros()
            elif escolha == '3':
                id_livro = int(input("ID do livro: "))
                novo_preco = float(input("Novo preço: "))
                self.atualizar_preco(id_livro, novo_preco)
            elif escolha == '4':
                id_livro = int(input("ID do livro: "))
                self.remover_livro(id_livro)
            elif escolha == '5':
                autor = input("Autor: ")
                self.buscar_por_autor(autor)
            elif escolha == '6':
                self.exportar_para_csv()
            elif escolha == '7':
                file_path = input("Caminho do arquivo CSV: ")
                self.importar_de_csv(file_path)
            elif escolha == '8':
                self.backup_banco()
            elif escolha == '9':
                break
            else:
                print("Opção inválida. Tente novamente.")


# Execução do sistema
if __name__ == "__main__":
    sistema_livraria = Livraria()
    sistema_livraria.menu()
