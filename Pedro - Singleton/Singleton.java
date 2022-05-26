package singleton;

public final class Singleton {
	private static Singleton instancia;
    public String valorQualquer;

    //Abaixo temos o construtor da classe como privado.
    private Singleton(String valorQualquer) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.valorQualquer = valorQualquer;
    }
    //Abaixo temos o método estático acessível que é chamado por outras classes para 
    //poder modificar este objeto afim de reutilizá-lo
    public static Singleton getinstancia(String valorQualquer) {
        if (instancia == null) {
            instancia = new Singleton(valorQualquer);
        }
        return instancia;
    }
}
