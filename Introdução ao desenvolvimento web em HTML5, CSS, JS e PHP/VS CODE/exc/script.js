function Calculo() {
    const Salario = parseFloat(document.getElementById('Salario').value);
    const Nome = document.getElementById('nome').value;
    let imposto;

    if (isNaN(Salario)) {
        document.getElementById('Resultado').textContent = 'Por favor, insira um valor válido para o salário.';
        return;
    }

    if (Salario <= 1903.98) {
        imposto = 0; // Isento
    } else if (Salario <= 2826.65) {
        imposto = (Salario - 1903.98) * 0.075; // 7.5% sobre o que exceder 1903.98
    } else if (Salario <= 3751.05) {
        imposto = (2826.65 - 1903.98) * 0.075 + (Salario - 2826.65) * 0.15; // 15% sobre o que exceder 2826.65
    } else if (Salario <= 4664.68) {
        imposto = (2826.65 - 1903.98) * 0.075 + (3751.05 - 2826.65) * 0.15 + (Salario - 3751.05) * 0.225; // 22.5% sobre o que exceder 3751.05
    } else {
        imposto = (2826.65 - 1903.98) * 0.075 + (3751.05 - 2826.65) * 0.15 + (4664.68 - 3751.05) * 0.225 + (Salario - 4664.68) * 0.275; // 27.5% sobre o que exceder 4664.68
    }

    document.getElementById('Resultado').textContent = 
        'Olá ' + Nome + ', o imposto de renda para um salário de R$' + Salario.toFixed(2) + ' é R$' + imposto.toFixed(2) + '.';
}
