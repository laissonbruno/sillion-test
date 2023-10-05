# Contador de Palavras

Este é um programa Java simples chamado "WordCounter" que permite contar o número de ocorrências de palavras em uma frase inserida pelo usuário e em um conteúdo obtido a partir de uma URL fornecida anteriormente pelo usuário.

## Pré-requisitos

Para executar este programa, é necessário ter o ambiente Java configurado em seu sistema. Certifique-se de que você tem o JDK (Java Development Kit) instalado.

## Como usar o programa

1. Execute o programa em um ambiente Java compatível, como uma IDE Java (Eclipse, IntelliJ, etc.) ou a partir da linha de comando.

2. Quando o programa for iniciado, ele solicitará duas entradas ao usuário:

   - **URL válida:** Insira uma URL válida da qual você deseja obter o conteúdo. O programa fará uma solicitação HTTP GET para essa URL para obter o conteúdo.

   - **Frase composta por N palavras:** Insira uma frase composta por um número qualquer de palavras. O programa irá contar quantas vezes cada palavra da frase ocorre no conteúdo da URL.

3. O programa buscará o conteúdo da URL fornecida e dividirá a frase em palavras individuais.

4. Em seguida, o programa contará quantas vezes cada palavra da frase ocorre no conteúdo da URL e apresentará os resultados.

## Funções do programa

### `fetchContentFromURL(String urlString)`

Esta função recebe uma URL como entrada e retorna o conteúdo obtido a partir dessa URL. Ela utiliza uma conexão HTTP GET para buscar o conteúdo.

### `countOccurrences(String content, String word)`

Esta função recebe o conteúdo de uma página da web (como uma string) e uma palavra como entrada. Ela conta quantas vezes a palavra fornecida ocorre no conteúdo da página.

### `countPhraseOccurrences(String content, String phrase)`

Conta quantas vezes uma determinada frase (representada pela variável phrase) aparece dentro de uma string de conteúdo (representada pela variável content).

### `main(String[] args)`

A função principal do programa, que controla a execução do programa. Ela lida com a entrada do usuário, chama as funções `fetchContentFromURL`, `countOccurrences` e `countPhraseOccurrences`, e exibe os resultados na saída padrão.

## Exemplo de Uso

Suponha que o usuário insira a seguinte entrada:

Insira um URL válido: https://es.wikipedia.org/wiki/Pir%C3%A1mides_de_Egipto
Insira uma frase composta por N palavras: bloques de piedra

Saída: 

"de" => é repetido 255 vezes
"piedra" => é repetido 3 vezes
"bloques" => é repetido 6 vezes
