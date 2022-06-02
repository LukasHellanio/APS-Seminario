package singleton;

public class DemoSingleThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Os valores resultantes da operacao abaixo serao 'FOO' pois apenas "
				+ "um objeto foi criado" + "\n");
		//Aqui vai criar o objeto Singleton pois no momento em que o metodo getInstancia checar
		// se o objeto instancia da classe Singleton é nulo, ele vai retornar true e a partir daí
		//vai chamar o construtor privado da classe instanciar um objeto do tipo Singleton
		Singleton primeiraInstancia = Singleton.getinstancia("FOO");
		//Quando o cliente cria uma segunda vez um objeto Singleton a partir do metodo getInstnacia
		// O metodo durante a checagem do objeto instancia vai retornar false, pois na linha 12 nos
		// o objeto "primeiraInstancia" foi o primeiro a chamar o metodo getInstancia e consequentemente
		// o primerio a criar o objeto Singleton, e por isso, tudo que chamar o singleton daqui em diante
		//será apenas o objeto "primeira instancia" sendo manipulado.
		Singleton segundaInstancia = Singleton.getinstancia("BAR");
		System.out.println("Valor passado para o objeto primeiraInstancia:'FOO'"+"\n");
        System.out.println("Valor setado no objeto primeiraInstancia: "+primeiraInstancia.valorQualquer+"\n");
        System.out.println("=============================================================================\n");
        System.out.println("Valor passado para o objeto segundaInstancia: 'BAR'"+"\n");
        System.out.println("Valor setado no objeto segundaInstancia: "+segundaInstancia.valorQualquer + "\n");
        System.out.println("=============================================================================\n");
        System.out.println("Agora temos uma modificacao no objeto, em uma das instancias, "
        		+ " e com isso todas as instancias serao alteradas \n");
        System.out.println("------------------------------------------------------------------------ \n");
        primeiraInstancia.valorQualquer = "BOO";
        System.out.println("Novo valor modificado no objeto primeiraInstancia: "+primeiraInstancia.valorQualquer+"\n");
        System.out.println("------------------------------------------------------------------------ \n");
        System.out.println("Valor que estava presente anteriormente no objeto primeiraInstancia: 'FOO'" + "\n");
        System.out.println("Novo valor setado no objeto primeiraInstancia: "+primeiraInstancia.valorQualquer+"\n");
        System.out.println("------------------------------------------------------------------------ \n");
        System.out.println("Valor que estava presente anteriormente no objeto segundaInstancia: 'FOO'"+ "\n");
        System.out.println("Novo valor do objeto segundaInstancia: "+segundaInstancia.valorQualquer + "\n");
        System.out.println("------------------------------------------------------------------------ \n");
	}

}
