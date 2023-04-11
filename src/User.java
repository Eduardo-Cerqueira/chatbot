
class User {
    private String pseudo;

    public User(String pseudo) throws IllegalArgumentException {
        if (pseudo.length() > 20) {
            throw new IllegalArgumentException("Veuillez entrer un pseudo de moins de 20 caractères.");
        }
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) throws IllegalArgumentException {
        if (pseudo.length() > 20) {
            throw new IllegalArgumentException("Veuillez entrer un pseudo de moins de 20 caractères.");
        }
        this.pseudo = pseudo;
    }
}
