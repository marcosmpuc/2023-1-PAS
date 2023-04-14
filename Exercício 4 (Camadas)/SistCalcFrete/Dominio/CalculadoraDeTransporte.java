package com.bcopstein.SistCalculoFreteP3.Dominio;

public class CalculadoraDeTransporte {

	public double calcularCustoParaEncomendaSimples(Cidade origem, Cidade destino, double pesoG) {
		double peso = converterDePesoG(pesoG);
		return calcularCustoBasico(origem, destino) +
				calcularAdicionalDePeso(peso) +
				calcularImposto();
	}
	
	public double calcularCustoBasico(Cidade origem, Cidade destino) {
		if (destino.equals(origem))
			return new SaoPaulo().getCustoBasico;
		
		double custoBasico;
		
		if (!destino.equals(new SaoPaulo())) {
			custoBasico += calcularCustoDeEntrega(origem, new SaoPaulo());
			custoBasico += calcularCustoDeEntrega(new SaoPaulo(), destino);
		} else {
			custoBasico = calcularCustoDeEntrega(origem, destino);
		}
		
		return custoBasico - getPromocaoVigente();
	}
	
	public double calcularCustoDeEntrega(Cidade origem, Cidade destino) {
		double custoEntrega = 2;

		return custoEntrega;
	}
	
	public double calcularImposto(double custoBasico) {
		/*if (imposto)*/
		/*else*/ return custoBasico * 0.05;
	}
	
	public double getPromocaoVigente() {
		double producaoVigente = 0;

		return producaoVigente;
	}
	
	public double converterDePesoG(double pesoG) {
		return Math.ceil(pesoG / 1000);
	}
	
	public double calcularAdicionalDePeso(double peso) {
		double adicional = 0;
		
		// lógica aqui
		
		return adicional - getPromocaoVigente();
	}
	
}
