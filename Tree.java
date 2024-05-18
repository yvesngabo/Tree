import java.io.File;

public class Tree {
    public static void main(String[] args) {
        // Vérifie si un répertoire est spécifié en argument
        if (args.length == 0) {
            System.out.println("Veuillez spécifier un répertoire.");
            return;
        }

        // Obtient le chemin du répertoire à explorer
        String directoryPath = args[0];

        // Appelle la méthode récursive pour afficher la structure arborescente
        displayDirectoryTree(new File(directoryPath), 0);
    }

    // Méthode récursive pour afficher la structure arborescente du répertoire
    private static void displayDirectoryTree(File directory, int depth) {
        // Vérifie si le répertoire existe
        if (!directory.exists()) {
            System.out.println("Le répertoire spécifié n'existe pas.");
            return;
        }

        // Vérifie si le fichier est un répertoire
        if (directory.isDirectory()) {
            // Affiche le nom du répertoire avec la profondeur appropriée
            System.out.println(getIndentation(depth) + directory.getName() + "/");

            // Obtient la liste des fichiers et répertoires dans ce répertoire
            File[] files = directory.listFiles();
            if (files != null) {
                // Parcours récursivement les sous-répertoires et les fichiers
                for (File file : files) {
                    displayDirectoryTree(file, depth + 1);
                }
            }
        } else {
            // Affiche le nom du fichier avec la profondeur appropriée
            System.out.println(getIndentation(depth) + directory.getName());
        }
    }

    // Méthode pour générer une indentation en fonction de la profondeur
    private static String getIndentation(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("|   ");
        }
        return indentation.toString();
    }
}
