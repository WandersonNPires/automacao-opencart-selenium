package utils;

import java.io.File;

public class PastasDocuments {
    public static void criarPastaSeNaoExistir(String nomePasta) {
        String caminhoBase = "documents/";
        File pasta = new File(caminhoBase + nomePasta);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }
}
