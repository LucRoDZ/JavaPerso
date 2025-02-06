package fr.epita.assistants.fgen;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FGen {
    private Path currentPath;

    public FGen(final String inputPath) {
        this.currentPath = Paths.get("").toAbsolutePath(); // Start in the current directory
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(inputPath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("jtrouve pas le file " + inputPath);
            }
            processFile(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("ERREUR: " + e.getMessage());
        }
    }

    private void processFile(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processCommand(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("ERREUR lecture: " + e.getMessage());
        }
    }

    private void processCommand(String command) {
        if (command.isEmpty() || command.length() < 2) return;

        char opcode = command.charAt(0);
        String path = command.substring(2).trim();
        Path targetPath = currentPath.resolve(path).normalize();

        try {
            switch (opcode) {
                case '+':
                    if (path.endsWith("/")) {
                        Files.createDirectories(targetPath);
                    } else {
                        Files.createFile(targetPath);
                    }
                    break;
                case '>':
                    if (!Files.exists(targetPath) || !Files.isDirectory(targetPath)) {
                        throw new RuntimeException("Destinitation inexistante : " + targetPath);
                    }
                    currentPath = targetPath;
                    break;
                case '-':
                    deleteRecursively(targetPath);
                    break;
                default:
                    throw new RuntimeException("commande inexistante: " + opcode);
            }
        } catch (FileAlreadyExistsException ignored) {

        } catch (IOException e) {
            throw new RuntimeException("ERREUR exec " + command + " - " + e.getMessage());
        }
    }

    private void deleteRecursively(Path path) throws IOException {
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                try (Stream<Path> paths = Files.walk(path)) {
                    paths.sorted((a, b) -> b.compareTo(a))
                            .forEach(p -> {
                                try {
                                    Files.delete(p);
                                } catch (IOException e) {
                                    throw new RuntimeException("ERRUER suppresion  " + p);
                                }
                            });
                }
            } else {
                Files.delete(path);
            }
        }
    }

    public static void main(String[] args) {
        new FGen("../resources/example.txt");
    }
}
