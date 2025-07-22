package utils;

import java.io.File;

public class PastasDocuments {
    public static void criarPastaSeNaoExistir(String caminho) {
        File pasta = new File(caminho);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }
}
