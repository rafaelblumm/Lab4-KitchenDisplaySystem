package utils;

import exceptions.CardapioVazioException;
import restaurante.Alimento;
import restaurante.Categoria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManipuladorBaseDados {
    private static final String SEPARADOR_CSV = ";";
    private final String nomeArquivo;
    private final String dirResources;

    public ManipuladorBaseDados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        dirResources = System.getProperty("user.dir") + "\\src\\main\\resources\\";
    }

    public ManipuladorBaseDados(String nomeArquivo, String dirResources) {
        this.nomeArquivo = nomeArquivo;
        this.dirResources = dirResources;
    }

    public ArrayList<Alimento> leCardapio() throws CardapioVazioException{
        File arquivo = new File(dirResources + nomeArquivo);

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            ArrayList<Alimento> itensCardapio = new ArrayList<>();
            String linha;
            String[] dados;

            while((linha = reader.readLine()) != null) {
                dados = linha.split(SEPARADOR_CSV);
                itensCardapio.add(new Alimento(dados[0], Float.parseFloat(dados[1]), Categoria.valueOf(dados[2])));
            }

            reader.close();

            if (itensCardapio.isEmpty())
                throw new CardapioVazioException("Registro de alimentos do cardápio vazio.");

            return itensCardapio;
        } catch (IOException e) {
            return null;
        }
    }
}
