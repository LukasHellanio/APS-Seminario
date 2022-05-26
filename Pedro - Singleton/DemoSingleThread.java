package singleton;

public class DemoSingleThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Os valores resultantes da operacao abaixo serao 'FOO' pois apenas"
				+ "um objeto foi criado" + "\n");
		Singleton primeiraInstancia = Singleton.getinstancia("FOO");
		Singleton segundaInstancia = Singleton.getinstancia("BAR");
		System.out.println("Primeira instancia:'FOO'");
        System.out.println("Valor do primeiro objeto instanciado: "+primeiraInstancia.valorQualquer);
        System.out.println("Segunda instancia: 'BAR'");
        System.out.println("Valor do segundo objeto instanciado: "+segundaInstancia.valorQualquer + "\n");
        System.out.println("Agora temos uma modificacao no objeto, em uma das instancias "
        		+ "e com isso, todas as instancias serao alteradas \n");
        primeiraInstancia.valorQualquer = "BOO";
        System.out.println("Nova modificacao no objeto: 'BOO'\n");
        System.out.println("Primeira instancia antiga: 'FOO'");
        System.out.println("Novo valor do primeiro obejto: "+primeiraInstancia.valorQualquer+"\n");
        System.out.println("Segunda instancia antiga: 'FOO'");
        System.out.println("Novo valor do segundo obejto: "+segundaInstancia.valorQualquer);
	}

}
