package de.wagnst.tpe.exercise.crypter;

/**
 * Grundlegendes Interface, um Verschlüsselung durchzuführen. Mit Hilfe dieses
 * Interfaces kann man Nachrichten verschlüsseln (über die {@link
 * #verschluesseln(String, String)} Methode) und wieder entschlüsseln (über die
 * {@link #entschluesseln(String, String)} Methode).
 * Der Eingabetext ({@literal message}) darf nur aus den Groß-Buchstaben A-Z
 * bestehen. Alle anderen Zeichen (einschließlich der Leerzeichen) führen zu
 * einer entsprechenden Ausnahme.
 * Bei der Entschlüsselung eines Textes, hängt es vom Verschlüsselungsverfahren
 * ab, welche Zeichen auftreten dürfen.
 * Zwischen den beiden Methoden muss bei gleichem Schlüssel {@code key}
 * folgendes gelten:
 * {@code text.equals(entschluesseln(key, verschluesseln(key, text)) == true}.
 */
public interface Crypter {

    /**
     * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param key     Schlüssel, der verwendet werden soll.
     * @param message Nachricht, die Verschlüsselt werden soll.
     * @return verschlüsselter Text.
     * @throws IllegalKeyException     Wird geworfen, wenn der Schlüssel nicht
     *                                 zum Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *                                 unerlaubte Zeichen enthält.
     */
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException;

    /**
     * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param key        Schlüssel, der verwendet werden soll.
     * @param cypherText Nachricht, die entschlüsselt werden soll.
     * @return entschlüsselter Text.
     * @throws IllegalKeyException     Wird geworfen, wenn der Schlüssel nicht
     *                                 zum Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *                                 unerlaubte Zeichen enthält.
     */
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException;
}