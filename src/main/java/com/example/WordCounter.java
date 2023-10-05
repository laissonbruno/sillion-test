package com.example;

import java.io.BufferedReader;             // Importa a classe BufferedReader para leitura de caracteres a partir de uma fonte de entrada.
import java.io.IOException;               // Importa a classe IOException para lidar com exceções de entrada/saída.
import java.io.InputStreamReader;         // Importa a classe InputStreamReader para ler caracteres de um fluxo de entrada.
import java.net.HttpURLConnection;       // Importa a classe HttpURLConnection para criar uma conexão HTTP.
import java.net.URL;                       // Importa a classe URL para representar uma URL.
import java.util.HashMap;                  // Importa a classe HashMap para criar um mapa (dicionário) de palavras e contagens.
import java.util.Map;                      // Importa a interface Map para trabalhar com mapas (dicionários) chave-valor.
import java.util.Scanner;                 // Importa a classe Scanner para ler entrada do usuário.


public class WordCounter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira uma URL válida.
        System.out.print("Insira um URL válido: ");
        String url = scanner.nextLine();

        // Solicita ao usuário que insira uma frase composta por N palavras.
        System.out.print("Insira uma frase composta por N palavras: ");
        String inputPhrase = scanner.nextLine();

        // Recupera o conteúdo da URL fornecida.
        String content = fetchContentFromURL(url);

        // Divide a frase de entrada em palavras com base nos espaços em branco.
        String[] words = inputPhrase.split("\\s+");

        // Cria um mapa para contar as ocorrências de cada palavra.
        Map<String, Integer> wordCount = new HashMap<>();

        // Itera sobre cada palavra na frase de entrada.
        for (String word : words) {
            // Conta as ocorrências da palavra no conteúdo da URL.
            int count = countOccurrences(content, word);
            // Armazena a contagem no mapa.
            wordCount.put(word, count);
        }

        // Conta as ocorrências da frase no conteúdo da URL.
        int phraseCount = countPhraseOccurrences(content, inputPhrase);

        // Exibe o resultado das contagens de palavras e da frase.
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\" => é repetido " + entry.getValue() + " vezes");
        }
        System.out.println("\"" + inputPhrase + "\" é repetido " + phraseCount + " vezes");


    }

    // Função para recuperar o conteúdo de uma URL.
    static String fetchContentFromURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            // Lê o conteúdo da URL linha por linha e o armazena no StringBuilder.
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } finally {
            connection.disconnect();
        }

        // Retorna o conteúdo como uma string.
        return content.toString();
    }

    // Função para contar ocorrências de uma palavra em um texto.
    static int countOccurrences(String content, String word) {
        String[] wordsInContent = content.split("\\s+");
        int count = 0;
        // Itera sobre as palavras no texto e conta as ocorrências da palavra especificada (ignorando maiúsculas/minúsculas).
        for (String w : wordsInContent) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        // Retorna o número de ocorrências da palavra.
        return count;
    }


    // Função para contar o número de vezes que a frase é repetida no conteúdo.
    private static int countPhraseOccurrences(String content, String phrase) {
        int count = 0;
        int index = content.indexOf(phrase);

        while (index != -1) {
            count++;
            index = content.indexOf(phrase, index + 1);
        }

        return count;
    }

}